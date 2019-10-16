package com.udemy.core;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty
    private long userId;

    @JsonProperty
    private String firstName;

    @JsonProperty
    private String lastName;

    @JsonProperty
    private String email;

    @JsonProperty
    private String role;

    public User() {
    }

    public User(long userId, String firstName, String lastName, String email, String role) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
    }
}
