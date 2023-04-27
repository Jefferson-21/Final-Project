/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author jeyarajjeyakumar
 */
public class PatientDirectory {

    
    ArrayList<Patient> allUsers;
    

    public PatientDirectory() {
        this.allUsers = new ArrayList<>();
    }
    
    

    public ArrayList<Patient> getAllPatient() {
        return allUsers;
    }

    public void setAllPatient(ArrayList<Patient> allUsers) {
        this.allUsers = allUsers;
    }
    
    public void addPatient(Patient newUser){
        this.allUsers.add(newUser);
    }
    
    public void removePatient(Patient user){
        this.allUsers.remove(user);
    }
    
    }
    
    
