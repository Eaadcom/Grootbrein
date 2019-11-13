package com.ipsen2.resources;

import com.ipsen2.api.Mapper.PersonMapper;
import com.ipsen2.api.Person;
import com.ipsen2.db.UserDAO;
import com.ipsen2.db.UserHasProjectDAO;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import io.dropwizard.auth.Auth;

/**
 * Receives the requests from the paths and calls the dao that is needed.
 * @author Melissa Basgol
 */

@Path("/users")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@RegisterMapper(PersonMapper.class)
public class UserResource {

    public UserDAO userDao;
    public UserHasProjectDAO userHasProjectDao;

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
    @Path("/{user_id}")
    public Response get(@PathParam("user_id") String user_id){
        if (userDao.findById(user_id) != null) {
            return Response.ok(userDao.findById(user_id)).build();
        } else {
            return Response.status(404).build();
        }
    }

    @DELETE
    @Path("/{user_id}")
    public void deleteById(@PathParam("user_id") String user_id) {
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
        Person updatePerson = new Person(person.getUser_id(),person.getFirst_name(),person.getLast_name(),
                person.getEmail(),person.getPassword());
        userDao.updateEmail(updatePerson);
        return updatePerson;
    }
}