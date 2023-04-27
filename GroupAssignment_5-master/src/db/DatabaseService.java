/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Community;
import Model.Doctor;
import Model.Patient;

public class DatabaseService {
	
	
	private final String url = "jdbc:mysql://localhost:3306/patients";
    private final String user = "root";
    private final String password = "password";

    public void savePatient(Patient patient) {

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO patient (name, email, patient_name, hospital_name, house_name, area_name, district, postal_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {

            statement.setString(1, patient.getName());
            statement.setString(2, patient.getEmail());
            statement.setString(3, patient.getPatientName());
            statement.setString(4, patient.getHospitalName());
            statement.setString(5, patient.getHouseName());
            statement.setString(6, patient.getAreaName());
            statement.setString(7, patient.getDistrict());
            statement.setString(8, patient.getPostalCode());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new patient has been inserted.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<Doctor> getDoctorsByCity(String city) throws SQLException {
        List<Doctor> doctors = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM doctors WHERE city = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, city);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Doctor doctor = new Doctor();
                        doctor.setDoctorId(rs.getInt("doctor_id"));
                        doctor.setDoctorName(rs.getString("doctor_name"));
                        doctor.setEmail(rs.getString("email"));
                        doctor.setPhoneNo(rs.getString("phone_no"));
                        doctor.setHospital(rs.getString("hospital"));
                        doctor.setCity(rs.getString("city"));
                        doctors.add(doctor);
                    }
                }
            }
        }

        return doctors;
    }

    

    public boolean addCommunity(Community community) {
    	
    	String INSERT_COMMUNITY_SQL = "INSERT INTO communities (location, district, city, province, pincode) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COMMUNITY_SQL)) {

            preparedStatement.setString(1, community.getLocation());
            preparedStatement.setString(2, community.getDistrict());
            preparedStatement.setString(3, community.getCity());
            preparedStatement.setString(4, community.getProvince());
            preparedStatement.setString(5, community.getPincode());

            int result = preparedStatement.executeUpdate();
            return (result > 0);

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Community> searchCommunities(String location, String district, String city, String province, String pincode) throws SQLException {
  
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Community> communities = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String sql = "SELECT * FROM communities WHERE location LIKE ? AND district LIKE ? AND city LIKE ? AND province LIKE ? AND pincode LIKE ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + location + "%");
            stmt.setString(2, "%" + district + "%");
            stmt.setString(3, "%" + city + "%");
            stmt.setString(4, "%" + province + "%");
            stmt.setString(5, "%" + pincode + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Community community = new Community();
                community.setLocation(rs.getString("location"));
                community.setDistrict(rs.getString("district"));
                community.setCity(rs.getString("city"));
                community.setProvince(rs.getString("province"));
                community.setPincode(rs.getString("pincode"));
                communities.add(community);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return communities;
    }
}

