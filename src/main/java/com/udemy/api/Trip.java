package com.udemy.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Trip {
    @JsonProperty
    private int tripId;
    @JsonProperty
    private int userId;
    @JsonProperty
    private int projectId;
    @JsonProperty
    private Date date;
    @JsonProperty
    private String startCoord;
    @JsonProperty
    private String endCoord;
    @JsonProperty
    private int km;

}
