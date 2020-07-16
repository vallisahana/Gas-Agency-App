package com.example.sahana.gasagency.Model;

// class with getter and setter methods to create single userdata as an object.

public class Dataprovider_Report {

    private String name,email,address,phone,status;

    public Dataprovider_Report() {
    }

    public Dataprovider_Report(String name, String email, String address, String phone, String status) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
