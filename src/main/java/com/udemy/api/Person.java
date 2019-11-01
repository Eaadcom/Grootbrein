package com.udemy.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

    @JsonProperty
    private int id;
    @JsonProperty
    private String name;

    public Person() {
        // Jackson deserialization
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonProperty
    public int getId() {
        return id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
