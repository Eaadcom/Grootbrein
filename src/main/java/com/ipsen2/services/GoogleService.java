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
     * This is the public class that can be called from outside the class to retrieve a GoogleJSONModel model
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
        Client client = ClientBuilder.newClient();
        String result = client.target("https://maps.googleapis.com/maps/api/" +
                "distancematrix/json?origins=" + origin + "&destinations=" + destination + "&key=AIzaSyD5kY3qkbU6tYmQwoExrjTFIuKQ5tz4PTQ").request().get(String.class);

        return result;
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
