package com.udemy.resources;

import com.udemy.DAO.ProjectDAO;

public class UserHasProjectResource {
    ProjectDAO dao;

    public UserHasProjectResource(ProjectDAO dao) {
        this.dao = dao;
    }
}
