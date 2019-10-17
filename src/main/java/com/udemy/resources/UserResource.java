package com.udemy.resources;

import com.udemy.DAO.UserDAO;

public class UserResource {

    UserDAO dao;

    public UserResource(UserDAO dao) {
        this.dao = dao;
    }

}
