package com.ipsen2.resources;

import com.ipsen2.api.Car;
import com.ipsen2.api.Mapper.CarMapper;
import com.ipsen2.db.CarDAO;
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
    @Path("/{user_id}")
    public Response getCarsById(@PathParam("user_id") String user_id){
        if (carDAO.getCarsOfUser(user_id) != null) {
                return Response.ok(carDAO.getCarsOfUser(user_id)).build();
            }
            else {
                return Response.status(404).build();
            }
    }

    /**
     * Deletes car
     * @author Matthijs van Eijk
     */
    @DELETE
    @Path("/{user_id}/{license_plate}")
    public void deleteById(@PathParam("user_id") String user_id, @PathParam("license_plate") String license_plate) {
        carDAO.deleteCarsOfUser(user_id, license_plate);
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

    @PUT
    @Path("/{user_id}/{license_plate}")
    public Car update(@PathParam("user_id") String user_id, @PathParam("license_plate") String license_plate, @Valid Car car) {
        Car updateCar = new Car(car.getLicense_id(),car.getLicense_plate(),car.getUser_id(),
                car.getReg_date());
        carDAO.updateFunction(updateCar);
        return updateCar;
    }
}
