package com.ipsen2.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Project model with json property variables
 * @author Melissa Basgol
 */

public class Project {
    @JsonProperty
    private int projectId;
    @JsonProperty
    private String projectName;

    public Project() {
    }

    public Project(int projectId, String projectName) {
        this.projectId = projectId;
        this.projectName = projectName;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
