package com.udemy.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    @JsonProperty
    private int carId;
    @JsonProperty
    private String licensePlate;

    public Car(int carId, String licensePlate) {
        this.carId = carId;
        this.licensePlate = licensePlate;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}