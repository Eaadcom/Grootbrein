package com.ipsen2.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipsen2.api.Trip;

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
