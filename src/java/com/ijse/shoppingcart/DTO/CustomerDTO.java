/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.DTO;

import com.ijse.shoppingcart.modal.*;

/**
 *
 * @author Hafees
 */
public class CustomerDTO extends SuperDTO{
    private String id;
    private String name;
    private String password;
    private String gender;
    private String dob;
    private int contact;

    public CustomerDTO() {
    }

    public CustomerDTO(String id, String name, String password, String gender, String dob, int contact) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        this.contact = contact;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    
    
}
