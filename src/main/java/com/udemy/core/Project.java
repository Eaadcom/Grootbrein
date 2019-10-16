package com.udemy.core;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Project {

    @JsonProperty
    private long projectId;

    @JsonProperty
    private long userId;

    @JsonProperty
    private String name;

    public Project(){

    }

    public Project(long projectId) {
        this.projectId = projectId;
        this.name = name;
        this.userId = userId;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
