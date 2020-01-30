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
    private int projectId;

    public UserHasProject() {
    }

    public UserHasProject(String userId, int projectId) {
        this.userId = userId;
        this.projectId = projectId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}
