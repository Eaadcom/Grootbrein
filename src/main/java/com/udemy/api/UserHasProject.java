package com.udemy.api;


import com.fasterxml.jackson.annotation.JsonProperty;

public class UserHasProject {
    @JsonProperty
    private int userId;
    @JsonProperty
    private int projectId;

    public UserHasProject(int userId, int projectId) {
        this.userId = userId;
        this.projectId = projectId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}
