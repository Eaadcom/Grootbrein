package com.udemy.resources;

import com.udemy.api.Mapper.PersonMapper;
import com.udemy.api.Person;
import com.udemy.db.ProjectDAO;
import com.udemy.db.UserDAO;
import com.udemy.db.UserHasProjectDAO;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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

    @GET
    @Path("/{email}/{password}")
    public Person getPersonLogin(@PathParam("email") String email, @PathParam("password") String password){
        System.out.println(userDao.findByEmail(email));
        if (userDao.findByEmail(email) != null) {
            if (userDao.findByEmail(email).getPassword().equals(password)) {
                return userDao.findByEmail(email);
            }
            else {
                return null;
            }
        }
        return null;
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
    public Person add(@Valid Person user) {
        userDao.insert(user);
        return user;
    }

    //email updaten van gebruiker werkt
    @PUT
    @Path("/{userId}")
    public Person updateEmail(@PathParam("userId") Integer userId, @Valid Person person) {
        Person updatePerson = new Person(person.getUser_id(),person.getFirst_name(), person.getLast_name(), person.getEmail(),person.getPassword());
        userDao.updateEmail(updatePerson);
        return updatePerson;
    }

}

