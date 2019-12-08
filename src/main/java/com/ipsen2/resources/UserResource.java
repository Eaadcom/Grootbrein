package com.ipsen2.resources;

import com.ipsen2.api.Mapper.PersonMapper;
import com.ipsen2.api.Person;
import com.ipsen2.db.ProjectDAO;
import com.ipsen2.db.UserDAO;
import com.ipsen2.db.UserHasProjectDAO;
import com.ipsen2.services.AuthenticationService;
//import io.dropwizard.auth.Auth;

import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Receives the requests from the paths and calls the dao that is needed.
 * @author Melissa Basgol
 */

@Path("/users")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@RegisterMapper(PersonMapper.class)
public class UserResource {

    UserDAO userDao;
    UserHasProjectDAO userHasProjectDao;

    public UserResource(UserDAO userDao, UserHasProjectDAO userHasProjectDao){
        this.userDao = userDao;
        this.userHasProjectDao= userHasProjectDao;
    }

    //Get all users
    @GET
    public Response getAll(){
        if (userDao.getAll() != null) {
            return Response.ok(userDao.getAll()).build();
        } else {
            return Response.status(404).build();
        }
    }

    @GET
    @Path("/{userId}")
    public Response get(@PathParam("userId") String userId){
        if (userDao.findById(userId) != null) {
            return Response.ok(userDao.findById(userId)).build();
        } else {
            return Response.status(404).build();
        }
    }

    @DELETE
    @Path("/{userId}")
    public void deleteById(@PathParam("userId") String user_id) {
        userDao.deleteById(user_id);
    }

    /**
     * Calls the dao to add a new user
     * @author Melissa Basgol
     */
    @POST
    public Response add(Person user) {
        userDao.insert(user);
        return Response.status(200).build();
    }

    @PUT
    @Path("/{userId}")
    public Person updateEmail(@PathParam("userId") Integer userId, @Valid Person person) {
        Person updatePerson = new Person(person.getUserId(),person.getFirstName(),person.getLastName(),
                person.getEmail(),person.getPassword());
        userDao.updateEmail(updatePerson);
        return updatePerson;
    }
}
