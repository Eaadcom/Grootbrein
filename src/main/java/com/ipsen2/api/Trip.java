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
    private String licensePlate;

    public Trip() {
    }


    public Trip(int tripId, String userId, int projectId, Timestamp regDate, String startCords, String endCords, int distance, String licensePlate) {
        this.tripId = tripId;
        this.userId = userId;
        this.projectId = projectId;
        this.regDate = regDate;
        this.startCords = startCords;
        this.endCords = endCords;
        this.distance = distance;
        this.licensePlate = licensePlate;
    }

    // Constructor without reg_date
    // Reg_date is auto incremented when adding trip to the database


    public Trip(String userId, int projectId, String startCords, String endCords, int distance, String licensePlate) {
        this.projectId = projectId;
        this.userId = userId;
        this.startCords = startCords;
        this.endCords = endCords;
        this.distance = distance;
        this.licensePlate = licensePlate;
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
}
