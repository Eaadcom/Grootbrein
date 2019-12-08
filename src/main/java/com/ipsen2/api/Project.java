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

    public int getProject_id() {
        return projectId;
    }

    public void setProject_id(int project_id) {
        this.projectId = project_id;
    }

    public String getProject_name() {
        return projectName;
    }

    public void setProject_name(String project_name) {
        this.projectName = projectName;
    }
}
