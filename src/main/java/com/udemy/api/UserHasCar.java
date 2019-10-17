package com.udemy.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserHasCar {
    @JsonProperty
    private long userId;

    @JsonProperty
    private long carId;

}
