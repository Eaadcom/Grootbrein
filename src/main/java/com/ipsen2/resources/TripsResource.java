package com.ipsen2.resources;

import com.ipsen2.api.Mapper.TripMapper;
import com.ipsen2.api.Trip;
import com.ipsen2.db.TripDAO;
import com.ipsen2.models.GoogleJSONModel;
import com.ipsen2.services.GoogleService;
import com.ipsen2.services.JSONservice;
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

@Path("/trip")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@RegisterMapper(TripMapper.class)
public class TripsResource {
    TripDAO tripDAO;
    JSONservice jsoNservice = new JSONservice();
    GoogleService googleService = new GoogleService();
    JWTService jwtService = new JWTService();

    public TripsResource(TripDAO tripDAO) {
        this.tripDAO = tripDAO;
    }

    @GET
    public Response getAll(@Context HttpHeaders headers) {
        if (jwtService.verifyJWT(headers.getRequestHeaders().getFirst("Authorization"))) {
            if (tripDAO.getAll() != null) {
                return Response.ok(tripDAO.getAll()).build();
            } else {
                return Response.status(404).build();
            }
        } else {
            return Response.status(401).build();
        }
    }

    /**
     * Calls the dao to get the trips of a user with the user_id
     *
     * @author Melissa Basgol
     */
    @GET
    @Path("/{userId}")
    public Response getTripsByUserId(@PathParam("userId") String userId, @Context HttpHeaders headers) {
        if (jwtService.verifyJWT(headers.getRequestHeaders().getFirst("Authorization"))) {
            if (tripDAO.getTripsByUserId(userId) != null) {
                return Response.ok(tripDAO.getTripsByUserId(userId)).build();
            } else {
                return Response.status(404).build();
            }
        } else {
            return Response.status(401).build();
        }
    }

    /**
     * Calls the dao to add a trip to the table "trip"
     *
     * @author Melissa Basgol
     */
    @POST
    public Response add(@Valid Trip trip, @Context HttpHeaders headers) {
        if (jwtService.verifyJWT(headers.getRequestHeaders().getFirst("Authorization"))) {
            GoogleJSONModel googleJSONModel = googleService.findDistance(trip.getStartCoordinates(), trip.getEndCoordinates());
            trip.setDistance(googleJSONModel.rows.get(0).elements.get(0).distance.value);
            tripDAO.insert(trip);
            return Response.ok(trip).build();
        } else {
            return Response.status(401).build();
        }
    }

    @DELETE
    @Path("/{tripId}")
    public Response deleteById(@PathParam("tripId") String tripId, @Context HttpHeaders headers) {
        if (jwtService.verifyJWT(headers.getRequestHeaders().getFirst("Authorization"))) {
            tripDAO.deleteTripById(tripId);
            return Response.ok().build();
        } else {
            return Response.status(401).build();
        }
    }
}
