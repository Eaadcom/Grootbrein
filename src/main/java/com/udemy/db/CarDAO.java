package com.udemy.db;

public class CarDAO {

    public String addCarQuery() {
        return " insert into car" + " values (?, ?)";
    }

    public String removeUserWithIdQuery() {
        return " delete from car where userId = ?;";
    }


    public String getUserNameFromId() {
        return " select * from user where userId = ?;";
    }
}
