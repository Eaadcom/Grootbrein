package com.ipsen2.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

/**
 * Person model with json property variables
 * @author Melissa Basgol
 */

public class Person {
    private static Person AuthUser;

    @JsonProperty
    private String userId;
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
    @JsonProperty
    private String email;
    @JsonProperty
    private String password;
    @JsonProperty
    private Timestamp regDate;
    @JsonProperty
    private String jwt;
    @JsonProperty
    private String role;

    public Person(){
    }

    public Person(String userId, String firstName, String lastName, String email, String password, Timestamp regDate, String role) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.regDate = regDate;
        this.role = role;
    }


    public Person(String userId, String firstName, String lastName, String email, String password, Timestamp regDate) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.regDate = regDate;
    }

    public Person(String userId, String firstName, String lastName, String email, String password, String role) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Person(String firstName, String lastName, String email, String password, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public static Person getAuthUser() {
        return AuthUser;
    }

    public void setRole(String role){ this.role = role; }

    public String getRole(){ return role; }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getRegDate() {
        return regDate;
    }

    public void setRegDate(Timestamp regDate) {
        this.regDate = regDate;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    //wordt niet gebruikt momenteel
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Person)) return false;
//
//        Person that = (Person) o;
//
//        if (getUser_id()!=(that.getUser_id())) return false;
//        if (!getFirst_name().equals(that.getFirst_name())) return false;
//
//        return true;
//    }
}
