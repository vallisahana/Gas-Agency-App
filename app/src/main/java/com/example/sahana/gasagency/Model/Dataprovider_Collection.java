package com.example.sahana.gasagency.Model;

// class with getter and setter methods to create single userdata as an object.

import java.io.Serializable;

public class Dataprovider_Collection implements Serializable {

    private String name,email,address,phone;

    public Dataprovider_Collection() {
    }

    public Dataprovider_Collection(String name, String email, String address, String phone) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
