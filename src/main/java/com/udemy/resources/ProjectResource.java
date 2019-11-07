package com.udemy.resources;


import com.udemy.api.Person;
import com.udemy.api.Project;
import com.udemy.db.ProjectDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/projects")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class ProjectResource {
    //werkt



    ProjectDAO projectDAO;

    public ProjectResource(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    @GET
    public List<Project> getAll(){
        return projectDAO.getAll();
    }

    //werkt
    @GET
    @Path("/{userId}")
    public List<Project> getProjectByUserId(@PathParam("userId") Integer userId){
        return projectDAO.getProjectsByUserId(userId);
    }
}
