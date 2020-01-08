package com.ipsen2.resources;

import com.ipsen2.api.Mapper.TripMapper;
import com.ipsen2.api.UserHasProject;
import com.ipsen2.db.UserHasProjectDAO;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
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

    public UserHasProjectResource(UserHasProjectDAO userhasprojDAO) {
        this.userHasProjectDAO = userhasprojDAO;
    }

    @GET
    public Response getAll(){
        if (userHasProjectDAO.getAll() != null) {
            return Response.ok(userHasProjectDAO.getAll()).build();
        } else {
            return Response.status(404).build();
        }
    }

    /**
     * Calls the dao to add userhasproject to the table "user_has_project"
     * @author Melissa Basgol
     */
    @POST
    public UserHasProject addUserToProject(@Valid UserHasProject userHasProject) {
        userHasProjectDAO.insert(userHasProject);
        return userHasProject;
    }

    @DELETE
    @Path("/{projectId}/{userId}")
    public void deleteUserFromProject(@PathParam("userId") String userId, @PathParam("projectId") String projectId) {
        userHasProjectDAO.deleteById(userId, projectId);
    }

}
