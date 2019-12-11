package com.ipsen2.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Loginn model with json property variables
 * @author Melissa Basgol
 */

public class Login {
    @JsonProperty
    private String email;
    @JsonProperty
    private String password;

    public Login() {
    }

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
