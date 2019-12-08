package com.ipsen2.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

/**
 * Car model with json property variables
 * @author Melissa Basgol
 */

public class Car {
    @JsonProperty
    private int licenseId;
    @JsonProperty
    private String licensePlate;
    @JsonProperty
    private String userId;
    @JsonProperty
    private Timestamp regDate;

    public Car() {
    }

    // Multiple constructors so that the client can post a car without all the properties


    public Car(int licenseId, String licensePlate, String userId, Timestamp regDate) {
        this.licenseId = licenseId;
        this.licensePlate = licensePlate;
        this.userId = userId;
        this.regDate = regDate;
    }

    public Car(int licenseId, String licensePlate) {
        this.licenseId = licenseId;
        this.licensePlate = licensePlate;
    }

    public Car(String licensePlate, String userId) {
        this.licensePlate = licensePlate;
        this.userId = userId;
    }

    public int getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(int licenseId) {
        this.licenseId = licenseId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
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
}
