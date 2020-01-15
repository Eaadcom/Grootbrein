package com.ipsen2.resources;


import com.ipsen2.api.Project;
import com.ipsen2.db.ProjectDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    @Path("/{userId}")
    public Response getProjectsByUserId(@PathParam("userId") String userId){
        if (projectDAO.getProjectsByUserId(userId) != null) {
            return Response.ok(projectDAO.getProjectsByUserId(userId)).build();
        }
        else {
            return Response.status(404).build();
        }
    }

    @GET
    @Path("/projectnames/{userId}")
    public Response getProjectNamesByUserId(@PathParam("userId") String userId){
        if (projectDAO.getProjectNamesByUserId(userId) != null) {
            return Response.ok(projectDAO.getProjectNamesByUserId(userId)).build();
        }
        else {
            return Response.status(404).build();
        }
    }

    @GET
    @Path("/projectname/{projectId}")
    public Response getProjectNameById(@PathParam("projectId") String projectId){
        if (projectDAO.getProjectNamesByUserId(projectId) != null) {
            return Response.ok(projectDAO.getProjectNamesByUserId(projectId)).build();
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
        projectDAO.insert(project);
        return Response.status(200).build();
    }

}
