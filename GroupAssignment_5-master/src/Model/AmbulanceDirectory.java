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
public class AmbulanceDirectory {

    
    ArrayList<Doctor> allUsers;
    

    public  AmbulanceDirectory () {
        this.allUsers = new ArrayList<>();
    }
    
    

    public ArrayList<Doctor> getAllDoctor() {
        return allUsers;
    }

    public void setAllDoctor(ArrayList<Doctor> allUsers) {
        this.allUsers = allUsers;
    }
    
    public void addDoctor(Doctor newUser){
        this.allUsers.add(newUser);
    }
    
}

    

