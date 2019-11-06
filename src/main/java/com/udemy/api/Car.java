package com.udemy.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public class Car {
   // @JsonProperty
   // private int license_id;
    @JsonProperty
    private String license_plate;
    @JsonProperty
    private String user_id;
   // @JsonProperty
   // private Timestamp reg_date;

    public Car() {
    }

    public Car(String license_plate, String user_id) {
        //.license_id = license_id;
        this.license_plate = license_plate;
        this.user_id = user_id;
        //this.reg_date = reg_date;
    }



    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }


}