package com.udemy.core;
        import com.fasterxml.jackson.annotation.JsonProperty;

public class UserHasProject {

    @JsonProperty
    private long userId;

    @JsonProperty
    private long projectId;

    public UserHasProject() {
    }

    public UserHasProject(long userId, long projectId) {
        this.userId = userId;
        this.projectId = projectId;
    }
}
