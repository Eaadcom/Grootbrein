package com.udemy.resources;

import com.udemy.api.Car;
import com.udemy.api.Mapper.TripMapper;
import com.udemy.api.Person;
import com.udemy.api.UserHasProject;
import com.udemy.db.UserHasProjectDAO;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

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


    @POST
    public UserHasProject addUserToProject(@Valid UserHasProject userHasProject) {
        userHasProjectDAO.insert(userHasProject);
        return userHasProject;
    }

    //werkt
    @DELETE
    @Path("/{project_id}/{user_id}")
    public void deleteUserFromProject(@PathParam("user_id") String user_id, @PathParam("project_id") String project_id) {
        userHasProjectDAO.deleteById(user_id, project_id);
    }

}
