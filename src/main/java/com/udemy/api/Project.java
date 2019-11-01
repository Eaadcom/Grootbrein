package com.udemy.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Project {
    @JsonProperty
    private int projectId;
    @JsonProperty
    private String name;
}
