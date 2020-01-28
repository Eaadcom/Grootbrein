package com.ipsen2.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipsen2.models.CoordinateModels.GoogleJSONModel;
import com.ipsen2.models.CoordinateModels.Location;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class PostalcodeCoordinateService {

    public Location getCoordinates(String postalcode){
        GoogleJSONModel jsonModel = mapJsonToModel(callAPI(postalcode));

        return jsonModel.results.get(0).geometry.location;
    }

    public void getPostalcode(){
        
    }

    //https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=YOUR_API_KEY
    private String callAPI(String address) {

        Client client = ClientBuilder.newClient();
        return client.target("https://maps.googleapis.com/maps/api/" +
                "geocode/json?address=" + address + "&key=AIzaSyD5kY3qkbU6tYmQwoExrjTFIuKQ5tz4PTQ").request().get(String.class);

    }

    private GoogleJSONModel mapJsonToModel(String result){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println(objectMapper.readValue(result , GoogleJSONModel.class).results);
            return objectMapper.readValue(result , GoogleJSONModel.class);

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
