package com.udemy.api;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;
import java.sql.Timestamp;

public class Trip {
    @JsonProperty
    private int tripId;
    @JsonProperty
    private int userId;
    @JsonProperty
    private int projectId;
    @JsonProperty
     private String timeStamp;
    @JsonProperty
     private String startCoord;
     @JsonProperty
     private String endCoord;
    @JsonProperty
    private int km;

    public Trip() {
    }

    public Trip(int tripId, int userId, int projectId, String timeStamp, String startCoord, String endCoord, int km) {
        this.tripId = tripId;
        this.userId = userId;
        this.projectId = projectId;
        this.timeStamp = timeStamp;
        this.startCoord = startCoord;
        this.endCoord = endCoord;
        this.km = km;
    }


    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timestamp) {
        this.timeStamp = timestamp;
    }

    public String getStartCoord() {
        return startCoord;
    }

    public void setStartCoord(String startCoord) {
        this.startCoord = startCoord;
    }

    public String getEndCoord() {
        return endCoord;
    }

    public void setEndCoord(String endCoord) {
        this.endCoord = endCoord;
    }
}