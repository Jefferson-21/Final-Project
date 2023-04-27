/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.Community;
import java.util.ArrayList;

/**
 *
 * @author JINESH
 */
public class Person {
      ArrayList<Community> allUsers;

    public Person() {
        this.allUsers = new ArrayList<>();
    }
    

    public ArrayList<Community> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(ArrayList<Community> allUsers) {
        this.allUsers = allUsers;
    }
    
    public void addPerson(Community newUser){
        this.allUsers.add(newUser);
    }
    
    public void removePerson(Community user){
        this.allUsers.remove(user);
    }

    public Iterable<Community> getAllPerson() {
        return (Iterable<Community>) allUsers.iterator();
    }

}
