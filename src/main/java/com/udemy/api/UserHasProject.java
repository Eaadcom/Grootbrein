package com.udemy.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserHasProject {
    @JsonProperty
    private long userId;

    @JsonProperty
    private long projectId;

}
