package com.example.sahana.gasagency.Model;

// class with getter and setter methods to create single userdata as an object.

public class Dataprovider_Feedback {

    private String user_name,user_email;


    public Dataprovider_Feedback() {
    }

    public Dataprovider_Feedback(String user_name, String user_email) {
        this.user_name = user_name;
        this.user_email = user_email;
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
}
