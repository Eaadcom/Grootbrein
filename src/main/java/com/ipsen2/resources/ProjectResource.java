package com.ipsen2.resources;


import com.ipsen2.api.Project;
import com.ipsen2.db.ProjectDAO;

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

    @GET
    public Response getAll(){
        if (projectDAO.getAll() != null) {
            return Response.ok(projectDAO.getAll()).build();
        }
        else {
            return Response.status(404).build();
        }
    }

    /**
     * Calls the dao to get the projects from a user
     * @author Melissa Basgol
     */
    @GET
    @Path("/{user_id}")
    public Response getProjectsByUserId(@PathParam("user_id") String user_id){
        if (projectDAO.getProjectsByUserId(user_id) != null) {
            return Response.ok(projectDAO.getProjectsByUserId(user_id)).build();
        }
        else {
            return Response.status(404).build();
        }
    }

    @GET
    @Path("/projectnames/{user_id}")
    public Response getProjectNamesByUserId(@PathParam("user_id") String user_id){
        if (projectDAO.getProjectNamesByUserId(user_id) != null) {
            return Response.ok(projectDAO.getProjectNamesByUserId(user_id)).build();
        }
        else {
            return Response.status(404).build();
        }
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
