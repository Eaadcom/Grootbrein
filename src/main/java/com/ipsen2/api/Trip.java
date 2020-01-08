package com.ipsen2.api;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

/**
 * Trip model with json property variables
 * @author Melissa Basgol
 */

public class Trip{
    @JsonProperty
    private int tripId;
    @JsonProperty
    private String userId;
    @JsonProperty
    private int projectId;
    @JsonProperty
    private Timestamp regDate;
    @JsonProperty
     private String startCords;
    @JsonProperty
     private String endCords;
    @JsonProperty
     private int distance;
    @JsonProperty
    private String license_plate;
    @JsonProperty
    private int project_id;

    public Trip() {
    }


    public Trip(int trip_id, String user_id, Timestamp reg_date, String start_cords, String end_cords, int distance, String license_plate, int project_id) {
        this.trip_id = trip_id;
        this.user_id = user_id;
        this.reg_date = reg_date;
        this.start_cords = start_cords;
        this.end_cords = end_cords;
        this.distance = distance;
        this.license_plate = license_plate;
        this.project_id = project_id;
    }

    // Constructor without reg_date
    // Reg_date is auto incremented when adding trip to the database


    public Trip(String userId, int projectId, String startCords, String endCords, int distance, String licensePlate) {
        this.projectId = projectId;
        this.userId = userId;
        this.startCords = startCords;
        this.endCords = endCords;
        this.distance = distance;
        this.license_plate = license_plate;
        this.project_id = project_id;
    }


    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Timestamp getRegDate() {
        return regDate;
    }

    public void setRegDate(Timestamp regDate) {
        this.regDate = regDate;
    }

    public String getStartCords() {
        return startCords;
    }

    public void setStartCords(String startCords) {
        this.startCords = startCords;
    }

    public String getEndCords() {
        return endCords;
    }

    public void setEndCords(String endCords) {
        this.endCords = endCords;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id){
        this.project_id = project_id;
    }
}
