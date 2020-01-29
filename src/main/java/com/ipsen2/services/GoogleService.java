package com.ipsen2.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipsen2.models.GoogleJSONModel;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 * This class hosts the service that interacts with the google maps API.
 *
 * @author Edward Deen
 * @version 05-11-2019
 */
public class GoogleService {

    /**
     * This is the public method that can be called from outside the class to retrieve a GoogleJSONModel model
     * containing the JSON data from the google maps API.
     *
     * @author Edward Deen
     * @version 05-11-2019
     */
    public GoogleJSONModel findDistance(String origin, String destination){
        GoogleJSONModel googleJsonModel = mapJsonToModel(callAPI(origin, destination));

        return googleJsonModel;
    }

    /**
     * This method calls the google maps API.
     *
     * @author Edward Deen
     * @version 05-11-2019
     */
    private String callAPI(String origin, String destination){
        String new_origin;
        String new_destination;
        if (origin.contains(",")) {
            String[] origin_arr = origin.split(",");
            new_origin = origin_arr[1] + "," + origin_arr[0];
        }else {
            new_origin = origin;
        }
        if (destination.contains(",")) {
            String[] destination_arr = destination.split(",");
            new_destination = destination_arr[1] + "," + destination_arr[0];
        }else {
            new_destination = destination;
        }

        System.out.println("https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + new_origin + "&destinations=" + new_destination + "&key=AIzaSyD5kY3qkbU6tYmQwoExrjTFIuKQ5tz4PTQ");
        Client client = ClientBuilder.newClient();
        return client.target("https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + new_origin + "&destinations=" + new_destination + "&key=AIzaSyD5kY3qkbU6tYmQwoExrjTFIuKQ5tz4PTQ").request().get(String.class);
    }

    /**
     * This method translates the JSON string it gets as an argument into the GoogleJSONModel.
     *
     * @author Edward Deen
     * @version 05-11-2019
     */
    private GoogleJSONModel mapJsonToModel(String result){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            GoogleJSONModel googleJsonModel = objectMapper.readValue(result , GoogleJSONModel.class);

            return googleJsonModel;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
