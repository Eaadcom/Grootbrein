package com.udemy.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Project {
    @JsonProperty
    private int projectId;
    @JsonProperty
    private String name;

    public Project(int projectId, String name) {
        this.projectId = projectId;
        this.name = name;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
