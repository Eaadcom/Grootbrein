package com.udemy.resources;
import com.udemy.DAO.CarDAO;
import com.udemy.core.Car;
import com.udemy.DAO.UserDAO;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/person")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class CarResource {

    CarDAO dao;

    public CarResource(CarDAO dao) {
        this.dao = dao;
    }

    @GET
    public List<Car> getAll(){
        return dao.getAll();
    }

    @GET
    @Path("/{id}")
    public Car get(@PathParam("id") Integer id){
        return dao.findById(id);
    }

    @POST
    public Car add(@Valid Car car) {
        dao.insertCar(car);
        return car;
    }

    @PUT
    @Path("/{id}")
    public Car update(@PathParam("id") Integer id, @Valid Car car) {
        Car updatePerson = new Car(id, car.getName());

        dao.update(updatePerson);

        return updatePerson;
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) {
        dao.deleteById(id);
    }
}
