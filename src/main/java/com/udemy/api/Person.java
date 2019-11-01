package com.udemy.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

    @JsonProperty
    private int userId;
    @JsonProperty
    private String firstName;

    /*
    @JsonProperty
    private String lastName;
    @JsonProperty
    private String email;
    @JsonProperty
    private String role;
*/
    public Person(int userId, String firstName) {
        // Jackson deserialization
        this.userId = userId;
        this.firstName = firstName;
    }

    public Person(int id, String firstName, String lastName, String email, String role) {
        this.userId = id;
        this.firstName = firstName;
        //this.lastName = lastName;
       // this.email = email;
       // this.role = role;
    }

    public int getId() {
        return userId;
    }

    public void setId(int id) {
        this.userId = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
/*
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    *
 */
}
