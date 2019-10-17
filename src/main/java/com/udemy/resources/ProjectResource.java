package com.udemy.resources;

import com.udemy.DAO.ProjectDAO;
import com.udemy.DAO.UserDAO;

public class ProjectResource {
    ProjectDAO dao;

    public ProjectResource(ProjectDAO dao) {
        this.dao = dao;
    }
}
