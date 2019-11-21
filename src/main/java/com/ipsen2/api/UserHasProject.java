package com.ipsen2.api;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * UserHasProject model with json property variables
 * @author Melissa Basgol
 */

public class UserHasProject {
    @JsonProperty
    private String user_id;
    @JsonProperty
    private String project_id;

    public UserHasProject() {
    }

    public UserHasProject(String user_id, String project_id) {
        this.user_id = user_id;
        this.project_id = project_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }
}
