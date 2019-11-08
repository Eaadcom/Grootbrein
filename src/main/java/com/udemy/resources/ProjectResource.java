package com.udemy.resources;


import com.udemy.api.Project;
import com.udemy.db.ProjectDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Receives the requests from the paths and calls the dao that is needed.
 * @author Melissa Basgol
 */

@Path("/projects")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class ProjectResource {
    ProjectDAO projectDAO;

    public ProjectResource(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    /*@GET
    public List<Project> getAll(){
        return projectDAO.getAll();
    } */

    /**
     * Calls the dao to get the projects from a user
     * @author Melissa Basgol
     */
    @GET
    @Path("/{user_id}")
    public List<Project> getProjectsByUserId(@PathParam("user_id") String user_id){
        System.out.println(projectDAO.getProjectsByUserId(user_id));
        return projectDAO.getProjectsByUserId(user_id);
    }

    @GET
    @Path("/projectnames/{user_id}")
    public List<String> getProjectNamesByUserId(@PathParam("user_id") String user_id){
        return projectDAO.getProjectNamesByUserId(user_id);
    }

    /**
     * Calls the dao to add a project to the table "project"
     * @author Melissa Basgol
     */
    @POST
    public Response add(Project project) {
        //if (authenticationService.authenticate(AuthKey) == false){
        //   userDao.insert(user);
        //   return Response.status(200).build();
        //return Response.status(403).build();
        //}
        projectDAO.insert(project);
        return Response.status(200).build();
    }
}
