package com.udemy.resources;
import com.udemy.DAO.CarDAO;
import com.udemy.api.Car;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hello")
//@Consumes({MediaType.APPLICATION_JSON})
//@Produces({MediaType.APPLICATION_JSON})
public class CarResource {

    CarDAO dao;

    //public CarResource(CarDAO dao) {
   //     this.dao = dao;
   // }

    public CarResource() {
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getGreeting(){
        return "Hello World";
    }

   // @GET
   // public List<Car> getAll(){
   //     return dao.getAll();
   // }
/*
    @GET
    @Path("/id")
    public String get(@PathParam("id") Integer id){ return "hello";}
    //{
    //        return dao.findById(id);

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

 */
}
