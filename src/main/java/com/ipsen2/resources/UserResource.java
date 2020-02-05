package com.ipsen2.resources;

import com.ipsen2.api.Mapper.PersonMapper;
import com.ipsen2.api.Person;
import com.ipsen2.db.UserDAO;
import com.ipsen2.db.UserHasProjectDAO;
import com.ipsen2.services.JWTService;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
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

    private static final String regexEmail = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
    public UserDAO userDao;
    public UserHasProjectDAO userHasProjectDao;
    JWTService jwtService = new JWTService();

    public UserResource(UserDAO userDao, UserHasProjectDAO userHasProjectDao){
        this.userDao = userDao;
        this.userHasProjectDao= userHasProjectDao;
    }

    //Get all users
    @GET
    public Response getAll(@Context HttpHeaders headers){
        if (jwtService.verifyJWT(headers.getRequestHeaders().getFirst("Authorization"))) {
            if (userDao.getAll() != null) {
                return Response.ok(userDao.getAll()).build();
            } else {
                return Response.status(404).build();
            }
        } else {
            return Response.status(401).build();
        }
    }

    /**
     * Endpoint that checks if a certain email
     * exists within our database
     *
     * @author Edward Deen
     * @param email
     * @return
     */
    @POST
    @Path("/checkEmail")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response checkIfEmailExists(String email){
        if(!email.matches(regexEmail)){
            return  Response.ok(false).build();
        }
        if (userDao.findByEmail(email) == null){
            return Response.ok(true).build();
        } else{
            return Response.ok(false).build();
        }
    }

    @GET
    @Path("/{userId}")
    public Response get(@PathParam("userId") String userId, @Context HttpHeaders headers){
        if (jwtService.verifyJWT(headers.getRequestHeaders().getFirst("Authorization"))) {
            if (userDao.findById(userId) != null) {
                return Response.ok(userDao.findById(userId)).build();
            } else {
                return Response.status(404).build();
            }
        } else {
            return Response.status(401).build();
        }
    }

    @GET
    @Path("/project/{projectId}")
    public Response getUsersOfProject(@PathParam("projectId") String projectId, @Context HttpHeaders headers){
        if (jwtService.verifyJWT(headers.getRequestHeaders().getFirst("Authorization"))) {
            return Response.ok(userDao.getAllUsersOfProject(projectId)).build();
        } else {
            return Response.status(401).build();
        }
    }

    @GET
    @Path("/email/{email}")
    public Response getUserWithEmail(@PathParam("email") String email, @Context HttpHeaders headers){
        if (jwtService.verifyJWT(headers.getRequestHeaders().getFirst("Authorization"))) {
            return Response.ok(userDao.findByEmail(email)).build();
        } else {
            return Response.status(401).build();
        }
    }


    @DELETE
    @Path("/{userId}")
    public Response deleteById(@PathParam("userId") String user_id, @Context HttpHeaders headers) {
        if (jwtService.verifyJWT(headers.getRequestHeaders().getFirst("Authorization"))) {
            userDao.deleteById(user_id);
            return Response.ok().build();
        } else {
            return Response.status(401).build();
        }
    }

    /**
     * Endpoint to change a user's password
     *
     * @author Edward Deen
     * @param user_id
     * @param password
     * @param headers
     * @return
     */
    @POST
    @Path("changePassword/{userId}")
    @Consumes(MediaType.TEXT_HTML)
    public Response changePassword(@PathParam("userId") String user_id, String password, @Context HttpHeaders headers) {
        if (jwtService.verifyJWT(headers.getRequestHeaders().getFirst("Authorization"))) {
            Person user = userDao.findById(user_id);
            user.setPassword(password);
            userDao.updatePassword(user_id, password);
            return Response.ok().build();
        } else {
            return Response.status(401).build();
        }
    }


    /**
     * Calls the dao to add a new user
     * @author Melissa Basgol
     */
    @POST
    public Response add(@Valid Person user, @Context HttpHeaders headers) {
            Person person = new Person(user.getUserId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getRole());
            userDao.insert(person);
            return Response.status(200).build();
    }

    @PUT
    @Path("/{userId}")
    public Response updateEmail(@PathParam("userId") Integer userId, @Valid Person person, @Context HttpHeaders headers) {
        if (jwtService.verifyJWT(headers.getRequestHeaders().getFirst("Authorization"))) {
            Person updatePerson = new Person(person.getUserId(),person.getFirstName(),person.getLastName(),
                    person.getEmail(),person.getPassword(), person.getRole());
            userDao.updateEmail(updatePerson);
            return Response.ok(updatePerson).build();
        } else {
            return Response.status(401).build();
        }
    }
}
