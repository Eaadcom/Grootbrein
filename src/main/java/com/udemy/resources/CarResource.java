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

    //werkt
    @GET
    public List<Car> getAll(){
        return carDAO.getAll();
    }

    //werkt
    @GET
    @Path("/{user_id}")
    public Response getCarsById(@PathParam("user_id") String user_id){
        return Response.ok(carDAO.getCarsOfUser(user_id)).build();
    }

    //werkt
    @POST
    public Car add(@Valid Car car) {
        carDAO.insert(car);
        return car;
    }
}
