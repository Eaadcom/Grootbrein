package com.udemy.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Project {
    @JsonProperty
    private int project_id;
    @JsonProperty
    private String user_id;
    @JsonProperty
    private String project_name;

    public Project() {
    }

    public Project(int project_id, String user_id, String project_name) {
        this.project_id = project_id;
        this.user_id = user_id;
        this.project_name = project_name;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }
}
