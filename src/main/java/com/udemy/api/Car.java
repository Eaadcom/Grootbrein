package com.udemy.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {

    @JsonProperty
    private long carId;

    @JsonProperty
    private String licensePlate;

    public Car(){
        // Jackson deserialization
    }

    public Car( long carId, String licensePlate, String description ){
        super();
        this.carId = carId;
        this.licensePlate=licensePlate;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
