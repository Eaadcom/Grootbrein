package com.udemy.resources;

import com.udemy.api.Mapper.PersonMapper;
import com.udemy.api.Mapper.UserHasProjectMapper;
import com.udemy.api.Person;
import com.udemy.api.Project;
import com.udemy.api.UserHasProject;
import com.udemy.db.ProjectDAO;
import com.udemy.db.UserDAO;
import com.udemy.db.UserHasProjectDAO;
import com.udemy.services.AuthenticationService;
import io.dropwizard.auth.Auth;
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

    public void creaTriggers()
    {
        userDao.createTrigger();
    }

    @GET
    public List<Person> getAll(){
        return userDao.getAll();
    }



    //werkt
    @GET
    @Path("/{id}")
    public Person get(@PathParam("id") Integer id){
        return userDao.findById(id);
    }

    //werkt
    @DELETE
    @Path("/{id}")
    public void deleteById(@PathParam("id") Integer id) {
        userDao.deleteById(id);
    }


    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response add(String string, @HeaderParam("AuthKey") String AuthKey) {
        if (authenticationService.authenticate(AuthKey) == false){
            return Response.status(403).build();
        }
        return Response.status(200).build();
    }

    //email updaten van gebruiker werkt
    @PUT
    @Path("/{userId}")
    public Person updateEmail(@PathParam("userId") Integer userId, @Valid Person person) {
        Person updatePerson = new Person(person.getuserId(),person.getfirstName(), person.getlastName(), person.getemail());
        userDao.updateEmail(updatePerson);
        return updatePerson;
    }
}
