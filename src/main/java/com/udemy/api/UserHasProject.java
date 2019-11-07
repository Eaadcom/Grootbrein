package com.udemy.api;


import com.fasterxml.jackson.annotation.JsonProperty;

public class UserHasProject {
    @JsonProperty
    private int user_id;
    @JsonProperty
    private int project_id;

    public UserHasProject() {
    }

    public UserHasProject(int user_id, int project_id) {
        this.user_id = user_id;
        this.project_id = project_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }
}
