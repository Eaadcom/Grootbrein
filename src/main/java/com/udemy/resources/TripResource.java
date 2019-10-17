package com.udemy.resources;

import com.udemy.DAO.TripDAO;
import com.udemy.DAO.UserDAO;

public class TripResource {
    TripDAO dao;

    public TripResource(TripDAO dao) {
        this.dao = dao;
    }
}
