package com.udemy.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserHasCar {
    @JsonProperty
    private int userId;
    @JsonProperty
    private String licensePlate;

    public UserHasCar() {
    }

    public UserHasCar(int userId, String licensePlate) {
        this.userId = userId;
        this.licensePlate = licensePlate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
