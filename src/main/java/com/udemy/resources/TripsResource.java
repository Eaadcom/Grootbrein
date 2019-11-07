package com.udemy.resources;

import com.udemy.api.Mapper.PersonMapper;
import com.udemy.api.Mapper.TripMapper;
import com.udemy.api.Person;
import com.udemy.api.Trip;
import com.udemy.db.TripDAO;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/trip")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@RegisterMapper(TripMapper.class)
public class TripsResource {
    TripDAO tripDAO;

    public TripsResource(TripDAO tripDAO) {
        this.tripDAO = tripDAO;
    }

    //werkt alle trips ophalen
    @GET
    public List<Trip> getAll(){
        return tripDAO.getAll();
    }

    @GET
    @Path("/{user_id}")
    public List<Trip> getTripsByUserId(@PathParam("user_id") String user_id) {
        return tripDAO.getTripsByUserId(user_id);}


    //werkt trip posten
    @POST
    public Trip add(@Valid Trip trip) {
        tripDAO.insert(trip);
        return trip;
    }

    //werkt
    @DELETE
    @Path("/{trip_id}")
    public void deleteById(@PathParam("trip_id") String trip_id) {
        tripDAO.deleteTripById(trip_id);
    }
}