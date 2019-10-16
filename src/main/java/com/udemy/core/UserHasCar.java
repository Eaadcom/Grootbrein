package com.udemy.core;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserHasCar {

    @JsonProperty
    private long userId;

    @JsonProperty
    private long carId;

    public UserHasCar() {
    }

    public UserHasCar(long userId, long carId) {
        this.userId = userId;
        this.carId = carId;
    }
}


