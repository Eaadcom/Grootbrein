package com.ipsen2.resources;

import com.ipsen2.api.Mapper.TripMapper;
import com.ipsen2.api.Trip;
import com.ipsen2.db.TripDAO;
import com.ipsen2.models.GoogleJSONModel;
import com.ipsen2.services.GoogleService;
import com.ipsen2.services.JSONservice;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Receives the requests from the paths and calls the dao that is needed.
 * @author Melissa Basgol
 */

@Path("/trip")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@RegisterMapper(TripMapper.class)
public class TripsResource {
    TripDAO tripDAO;
    JSONservice jsoNservice = new JSONservice();
    GoogleService googleService = new GoogleService();

    public TripsResource(TripDAO tripDAO) {
        this.tripDAO = tripDAO;
    }

    @GET
    public Response getAll(){
        if (tripDAO.getAll() != null) {
            return Response.ok(tripDAO.getAll()).build();
        } else {
            return Response.status(404).build();
        }
    }

    /**
     * Calls the dao to get the trips of a user with the user_id
     * @author Melissa Basgol
     */
    @GET
    @Path("/{user_id}")
    public Response getTripsByUserId(@PathParam("user_id") String user_id) {
        if (tripDAO.getTripsByUserId(user_id) != null) {
            return Response.ok(tripDAO.getTripsByUserId(user_id)).build();
        } else {
            return Response.status(404).build();
        }
    }

    /**
     * Calls the dao to add a trip to the table "trip"
     * @author Melissa Basgol
     */
    @POST
    public Trip add(@Valid Trip trip) {
        GoogleJSONModel googleJSONModel = googleService.findDistance(trip.getStart_cords(), trip.getEnd_cords());
        trip.setDistance(googleJSONModel.rows.get(0).elements.get(0).distance.value);
        tripDAO.insert(trip);
        return trip;
    }

    @DELETE
    @Path("/{trip_id}")
    public void deleteById(@PathParam("trip_id") String trip_id) {
        tripDAO.deleteTripById(trip_id); }

}