package com.udemy.api;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Trip {

    @JsonProperty
    private long tripId;

    @JsonProperty
    private long userId;

    @JsonProperty
    private long projectId;

    @JsonProperty
    private Date date;

    @JsonProperty
    private String startCoord;

    @JsonProperty
    private String endCoord;

    @JsonProperty
    private int kilometers;

    public Trip() {
        // Jackson deserialization

    }

    public Trip(long tripId, long userId, long projectId, Date date, String startCoord, String endCoord, int kilometers) {
        this.tripId = tripId;
        this.userId = userId;
        this.projectId = projectId;
        this.date = date;
        this.startCoord = startCoord;
        this.endCoord = endCoord;
        this.kilometers = kilometers;
    }


}
