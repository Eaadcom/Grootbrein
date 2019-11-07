package com.udemy.resources;

import com.udemy.api.Mapper.PersonMapper;
import com.udemy.api.Person;
import com.udemy.db.ProjectDAO;
import com.udemy.db.UserDAO;
import com.udemy.db.UserHasProjectDAO;
import org.eclipse.jetty.http.HttpTester;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@RegisterMapper(PersonMapper.class)
public class UserResource {

    UserDAO userDao;
    UserHasProjectDAO userHasProjectDao;
    ProjectDAO projectDao;


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
    public Person add(@Valid Person user) {
        userDao.insert(user);
        return user;
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

