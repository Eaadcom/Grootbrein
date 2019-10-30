package com.udemy.db;

public class UserDAO {
    public String addUserQuery() {
        return " insert into user (user_id, email)" + " values (?, ?)";
    }

    public String removeUserWithIdQuery() {
        return " delete from user where userId = ?;";
    }


    public String getUserNameFromId() {
        return " select * from user where userId = ?;";
    }
}
