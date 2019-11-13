package com.ipsen2.resources;

import com.ipsen2.api.Mapper.TripMapper;
import com.ipsen2.api.UserHasProject;
import com.ipsen2.db.UserHasProjectDAO;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
    public List<UserHasProject> getAll(){
        return userHasProjectDAO.getAll();
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
    @Path("/{project_id}/{user_id}")
    public void deleteUserFromProject(@PathParam("user_id") String user_id, @PathParam("project_id") String project_id) {
        userHasProjectDAO.deleteById(user_id, project_id);
    }

}
