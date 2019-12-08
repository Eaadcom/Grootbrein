package com.ipsen2.api;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * UserHasProject model with json property variables
 * @author Melissa Basgol
 */

public class UserHasProject {
    @JsonProperty
    private String userId;
    @JsonProperty
    private String projectId;

    public UserHasProject() {
    }

    public UserHasProject(String userId, String projectId) {
        this.userId = userId;
        this.projectId = projectId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
