package com.udemy.resources;

import com.udemy.api.Car;
import com.udemy.api.Mapper.CarMapper;
import com.udemy.db.CarDAO;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Receives the requests from the paths and calls the dao that is needed.
 * @author Melissa Basgol
 */

@Path("/cars")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@RegisterMapper(CarMapper.class)
public class CarResource {
    CarDAO carDAO;

    public CarResource() {
    }

    public CarResource(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GET
    public List<Car> getAll(){
        return carDAO.getAll();
    }

    /**
     * Returns as response an entity with a list with the license plates of the user
     * @author Melissa Basgol
     */
    @GET
    @Path("/{user_id}")
    public Response getCarsById(@PathParam("user_id") String user_id){
        return Response.ok(carDAO.getCarsOfUser(user_id)).build();
    }

    /**
     * Calls the dao to add a car to the table "car" in the database
     * @author Melissa Basgol
     */
    @POST
    public Car add(@Valid Car car) {
        carDAO.insert(car);
        return car;
    }
}
