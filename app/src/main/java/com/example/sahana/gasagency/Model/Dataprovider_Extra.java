package com.example.sahana.gasagency.Model;

// class with getter and setter methods to create single userdata as an object.

import java.io.Serializable;

public class Dataprovider_Extra implements Serializable {

  private String ename,edate,ephone;

    public Dataprovider_Extra() {
    }

    public Dataprovider_Extra(String ename, String edate, String ephone) {
        this.ename = ename;
        this.edate = edate;
        this.ephone = ephone;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }

    public String getEphone() {
        return ephone;
    }

    public void setEphone(String ephone) {
        this.ephone = ephone;
    }
}
