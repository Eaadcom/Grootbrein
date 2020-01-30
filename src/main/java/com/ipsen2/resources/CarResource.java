package com.ipsen2.resources;

import com.ipsen2.api.Car;
import com.ipsen2.api.Mapper.CarMapper;
import com.ipsen2.db.CarDAO;
import com.ipsen2.services.JWTService;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
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
    JWTService jwtService = new JWTService();

    public CarResource(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GET
    public Response getAll(@Context HttpHeaders headers){
        if (jwtService.verifyJWT(headers.getRequestHeaders().getFirst("Authorization"))){
            if (carDAO.getAll() != null) {
                return Response.ok(carDAO.getAll()).build();
            }
            else {
                return Response.status(404).build();
            }
        } else {
            return Response.status(401).build();
        }
    }

    /**
     * Returns as response an entity with a list with the license plates of the user
     * @author Melissa Basgol
     */
    @GET
    @Path("/{userId}")
    public Response getCarsById(@PathParam("userId") String userId, @Context HttpHeaders headers){
        if (jwtService.verifyJWT(headers.getRequestHeaders().getFirst("Authorization"))){
            if (carDAO.getCarsOfUser(userId) != null) {
                return Response.ok(carDAO.getCarsOfUser(userId)).build();
            }
            else {
                return Response.status(404).build();
            }
        } else {
            return Response.status(401).build();
        }
    }

    @DELETE
    @Path("/{carId}")
    public Response deleteCarById(@PathParam("carId") String carId, @Context HttpHeaders headers){
        if (jwtService.verifyJWT(headers.getRequestHeaders().getFirst("Authorization"))){
            carDAO.deleteById(carId);
            return Response.ok().build();
        } else {
            return Response.status(401).build();
        }
    }

    /**
     * Calls the dao to add a car to the table "car" in the database
     * @author Melissa Basgol
     */
    @POST
    public Response add(@Valid Car car, @Context HttpHeaders headers) {
        if (jwtService.verifyJWT(headers.getRequestHeaders().getFirst("Authorization"))){
            carDAO.insert(car);
            return Response.ok(car).build();
        } else {
            return Response.status(401).build();
        }
    }
}
