package com.udemy.resources;


import com.udemy.api.Person;
import com.udemy.api.Project;
import com.udemy.db.ProjectDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/projects")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class ProjectResource {
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
    @Path("/{user_id}")
    public Response getProjectsByUserId(@PathParam("user_id") String user_id){
        List<Project> projectList = projectDAO.getProjectsByUserId(user_id);
        GenericEntity<List<Project>> entity =
                new GenericEntity<List<Project>>(projectList) {};

        return Response.ok(entity).build();
    }

    //werkt
    @GET
    @Path("/projectnames/{user_id}")
    public List<String> getProjectNamesByUserId(@PathParam("user_id") String user_id){
        return projectDAO.getProjectNamesByUserId(user_id);
    }
}
