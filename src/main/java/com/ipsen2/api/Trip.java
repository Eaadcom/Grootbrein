package com.ipsen2.api;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

/**
 * Trip model with json property variables
 * @author Melissa Basgol
 */

public class Trip {
    @JsonProperty
    private int trip_id;
    @JsonProperty
    private String user_id;
    @JsonProperty
    private Timestamp reg_date;
    @JsonProperty
     private String start_cords;
    @JsonProperty
     private String end_cords;
    @JsonProperty
     private int distance;
    @JsonProperty
    private String license_plate;

    public Trip() {
    }


    public Trip(int trip_id, String user_id, Timestamp reg_date, String start_cords, String end_cords, int distance, String license_plate) {
        this.trip_id = trip_id;
        this.user_id = user_id;
        this.reg_date = reg_date;
        this.start_cords = start_cords;
        this.end_cords = end_cords;
        this.distance = distance;
        this.license_plate = license_plate;
    }

    // Constructor without reg_date
    // Reg_date is auto incremented when adding trip to the database
    public Trip(String user_id, String start_cords, String end_cords, int distance, String license_plate) {
        this.user_id = user_id;
        this.start_cords = start_cords;
        this.end_cords = end_cords;
        this.distance = distance;
        this.license_plate = license_plate;
    }

    public int getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Timestamp getReg_date() {
        return reg_date;
    }

    public void setReg_date(Timestamp reg_date) {
        this.reg_date = reg_date;
    }

    public String getStart_cords() {
        return start_cords;
    }

    public void setStart_cords(String start_cords) {
        this.start_cords = start_cords;
    }

    public String getEnd_cords() {
        return end_cords;
    }

    public void setEnd_cords(String end_cords) {
        this.end_cords = end_cords;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }
}