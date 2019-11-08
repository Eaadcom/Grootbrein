package com.udemy.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udemy.api.Trip;
import com.udemy.models.TripModel;

public class JSONservice {

    public Trip mapTripModel(String jsonString){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            Trip trip = objectMapper.readValue(jsonString , Trip.class);

            return trip;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public String tripModelToString(Trip trip){
        try{
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(trip);
            return jsonString;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
