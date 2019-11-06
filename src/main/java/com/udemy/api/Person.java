package com.udemy.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

    @JsonProperty
    private int userId;
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
    @JsonProperty
    private String email;
    @JsonProperty
    private String password;


    public Person() {
    }

    public Person(int id, String firstName, String lastName, String email, String password) {
        this.userId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public int getuserId() {
        return userId;
    }

    public void setuserId(int id) {
        this.userId = id;
    }

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //wordt niet gebruikt momenteel
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person that = (Person) o;

        if (getuserId()!=(that.getuserId())) return false;
        if (!getfirstName().equals(that.getfirstName())) return false;

        return true;
    }



}
