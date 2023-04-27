/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author jeyarajjeyakumar
 */
public class Vaccination {
    String Patientname;
    String PatientnameID;
    String VaccinationType;
    String VaccinationDose;
    String HealthCareProvider;

    public String getPatientname() {
        return Patientname;
    }

    public void setPatientname(String Patientname) {
        this.Patientname = Patientname;
    }

    public String getPatientnameID() {
        return PatientnameID;
    }

    public void setPatientnameID(String PatientnameID) {
        this.PatientnameID = PatientnameID;
    }

    public String getVaccinationType() {
        return VaccinationType;
    }

    public void setVaccinationType(String VaccinationType) {
        this.VaccinationType = VaccinationType;
    }

    public String getVaccinationDose() {
        return VaccinationDose;
    }

    public void setVaccinationDose(String VaccinationDose) {
        this.VaccinationDose = VaccinationDose;
    }

    public String getHealthCareProvider() {
        return HealthCareProvider;
    }

    public void setHealthCareProvider(String HealthCareProvider) {
        this.HealthCareProvider = HealthCareProvider;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String ContactNumber) {
        this.ContactNumber = ContactNumber;
    }
    String ContactNumber;
    
}
