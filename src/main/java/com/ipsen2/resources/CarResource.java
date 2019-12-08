package com.ipsen2.resources;

import com.ipsen2.api.Car;
import com.ipsen2.api.Mapper.CarMapper;
import com.ipsen2.db.CarDAO;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    public Response getAll(){
        if (carDAO.getAll() != null) {
            return Response.ok(carDAO.getAll()).build();
        }
        else {
            return Response.status(404).build();
        }
    }

    /**
     * Returns as response an entity with a list with the license plates of the user
     * @author Melissa Basgol
     */
    @GET
    @Path("/{userId}")
    public Response getCarsById(@PathParam("userId") String userId){
        if (carDAO.getCarsOfUser(userId) != null) {
                return Response.ok(carDAO.getCarsOfUser(userId)).build();
            }
            else {
                return Response.status(404).build();
            }
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
