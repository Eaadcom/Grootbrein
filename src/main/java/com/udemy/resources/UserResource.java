package com.udemy.resources;

import com.udemy.api.Mapper.PersonMapper;
import com.udemy.api.Person;
import com.udemy.db.ProjectDAO;
import com.udemy.db.UserDAO;
import com.udemy.db.UserHasProjectDAO;
import com.udemy.services.AuthenticationService;
//import io.dropwizard.auth.Auth;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import sun.net.www.http.HttpClient;

import javax.annotation.Priority;
import javax.annotation.RegEx;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.*;
import java.util.List;

import static javax.ws.rs.core.Response.serverError;

@Path("/users")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@RegisterMapper(PersonMapper.class)
public class UserResource {

    UserDAO userDao;
    UserHasProjectDAO userHasProjectDao;
    ProjectDAO projectDao;
    AuthenticationService authenticationService = new AuthenticationService();


    public UserResource(UserDAO userDao, UserHasProjectDAO userHasProjectDao){
        this.userDao = userDao;
        this.userHasProjectDao= userHasProjectDao;
    }

    @GET
    public List<Person> getAll(){
        return userDao.getAll();
    }

    /*
    @GET
    @Path("/{email}/{password}")
    public Response getPersonLogin(@PathParam("email") String email, @PathParam("password") String password){
        System.out.println(userDao.findByEmail(email));
        if (userDao.findByEmail(email) != null) {
            if (userDao.findByEmail(email).getPassword().equals(password)) {
                System.out.println(userDao.findByEmail(email));
                return Response.ok(userDao.findByEmail(email)).build();
            }
            else {
                return Response.status(409).build();
            }
        }
        return null;
    }
*/
    //werkt
    @GET
    @Path("/{user_id}")
    public Person get(@PathParam("user_id") String user_id){
        return userDao.findById(user_id);
    }

    //werkt
    @DELETE
    @Path("/{user_id}")
    public void deleteById(@PathParam("user_id") String user_id) {
        userDao.deleteById(user_id);
    }


    @POST
    public Response add(Person user) {
        //if (authenticationService.authenticate(AuthKey) == false){
         //   userDao.insert(user);
         //   return Response.status(200).build();
            //return Response.status(403).build();
        //}
        userDao.insert(user);
        return Response.status(200).build();
    }

    //email updaten van gebruiker werkt
    @PUT
    @Path("/{userId}")
    public Person updateEmail(@PathParam("userId") Integer userId, @Valid Person person) {
        Person updatePerson = new Person(person.getUser_id(),person.getFirst_name(),person.getLast_name(),
                person.getEmail(),person.getPassword());
        userDao.updateEmail(updatePerson);
        return updatePerson;
    }
}
