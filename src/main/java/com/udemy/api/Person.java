package com.udemy.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public class Person {

    @JsonProperty
    private String user_id;
    @JsonProperty
    private String first_name;
    @JsonProperty
    private String last_name;
    @JsonProperty
    private String email;
    @JsonProperty
    private String password;
    @JsonProperty
    private Timestamp reg_date;

    public Person() {
    }

    public Person(String user_id, String first_name, String last_name, String email, String password) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
    }

    public Person(String user_id, String first_name, String last_name, String email, String password, Timestamp reg_date) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.reg_date = reg_date;
    }


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public Timestamp getReg_date() {
        return reg_date;
    }

    public void setReg_date(Timestamp reg_date) {
        this.reg_date = reg_date;
    }

    //wordt niet gebruikt momenteel
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person that = (Person) o;

        if (getUser_id()!=(that.getUser_id())) return false;
        if (!getFirst_name().equals(that.getFirst_name())) return false;

        return true;
    }



}
