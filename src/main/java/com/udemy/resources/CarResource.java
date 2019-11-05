package com.udemy.resources;

import com.udemy.api.Mapper.PersonMapper;
import com.udemy.api.Mapper.UserHasCarMapper;
import com.udemy.api.Person;
import com.udemy.api.Project;
import com.udemy.api.UserHasCar;
import com.udemy.db.UserHasCarDAO;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/cars")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@RegisterMapper(UserHasCarMapper.class)
public class CarResource {
    UserHasCarDAO userHasCarDAO;

    public CarResource() {
    }

    public CarResource(UserHasCarDAO userHasCarDAO) {
        this.userHasCarDAO = userHasCarDAO;
    }

    //werkt
    @GET
    public List<UserHasCar> getAll(){
        return userHasCarDAO.getAll();
    }

    //werkt
    @GET
    @Path("/{userId}")
    public List<UserHasCar> getProjectById(@PathParam("userId") int userId){
        return userHasCarDAO.getCarsOfUser(userId);
    }

    //werkt
    @POST
    public UserHasCar add(@Valid UserHasCar car) {
        userHasCarDAO.insert(car);
        return car;
    }
}
