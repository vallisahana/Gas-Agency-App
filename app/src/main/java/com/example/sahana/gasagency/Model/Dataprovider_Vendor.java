package com.example.sahana.gasagency.Model;

// class with getter and setter methods to create single userdata as an object.

public class Dataprovider_Vendor {

    private String user_name,user_email,user_password,user_phone;

    public Dataprovider_Vendor() {
    }

    public Dataprovider_Vendor(String user_name, String user_email, String user_password, String user_phone) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_phone = user_phone;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }
}
