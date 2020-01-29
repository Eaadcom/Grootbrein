package com.ipsen2.resources;

import com.ipsen2.api.Mapper.TripMapper;
import com.ipsen2.api.UserHasProject;
import com.ipsen2.db.UserHasProjectDAO;
import com.ipsen2.services.JWTService;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/**
 * Receives the requests from the paths and calls the dao that is needed.
 * @author Melissa Basgol
 */

@Path("/userhasproject")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@RegisterMapper(TripMapper.class)
public class UserHasProjectResource {

    UserHasProjectDAO userHasProjectDAO;
    JWTService jwtService = new JWTService();

    public UserHasProjectResource(UserHasProjectDAO userhasprojDAO) {
        this.userHasProjectDAO = userhasprojDAO;
    }

    @GET
    public Response getAll(@Context HttpHeaders headers){
        if (jwtService.verifyJWT(headers.getRequestHeaders().getFirst("Authorization"))) {
            if (userHasProjectDAO.getAll() != null) {
                return Response.ok(userHasProjectDAO.getAll()).build();
            } else {
                return Response.status(404).build();
            }
        } else {
            return Response.status(401).build();
        }
    }

    /**
     * Calls the dao to add userhasproject to the table "user_has_project"
     * @author Melissa Basgol
     */
    @POST
    public Response addUserToProject(@Valid UserHasProject userHasProject, @Context HttpHeaders headers) {
        if (jwtService.verifyJWT(headers.getRequestHeaders().getFirst("Authorization"))) {
            userHasProjectDAO.insert(userHasProject);
            return Response.ok(userHasProject).build();
        } else {
            return Response.status(401).build();
        }
    }

    @DELETE
    @Path("/{projectId}/{userId}")
    public Response deleteUserFromProject(@PathParam("userId") String userId, @PathParam("projectId") String projectId, @Context HttpHeaders headers) {
        if (jwtService.verifyJWT(headers.getRequestHeaders().getFirst("Authorization"))) {
            userHasProjectDAO.deleteById(userId, projectId);
            return Response.ok().build();
        } else {
            return Response.status(401).build();
        }
    }
}
