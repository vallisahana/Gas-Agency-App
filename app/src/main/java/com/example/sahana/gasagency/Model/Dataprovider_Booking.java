package com.example.sahana.gasagency.Model;

// class with getter and setter methods to create single userdata as an object.

import java.io.Serializable;

public class Dataprovider_Booking implements Serializable {

    private String id,date,time,address,price,phone,radio;

    public Dataprovider_Booking() {
    }

    public Dataprovider_Booking(String id, String date, String time, String address, String price, String phone, String radio) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.address = address;
        this.price = price;
        this.phone = phone;
        this.radio = radio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }
}
