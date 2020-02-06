package com.ipsen2.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipsen2.models.CoordinateModels.GoogleJSONModel;
import com.ipsen2.models.CoordinateModels.Location;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 * Service that talks to the google api to retrieve information about a certain location
 *
 * @author Edward Deen
 */
public class PostalcodeCoordinateService {

    /**
     * Public method that returns the postal code of the input coordinates
     *
     * @author Edward Deen
     * @param postalcode
     * @return
     */
    public Location getCoordinates(String postalcode){
        GoogleJSONModel jsonModel = mapJsonToModel(callAPI(postalcode));
        return jsonModel.results.get(0).geometry.location;
    }

    /**
     * Public method that returns data about the coordinates input
     *
     * @author Edward Deen
     * @param coordinates
     * @return
     */
    public GoogleJSONModel getDataByCoordinates(String coordinates){
        GoogleJSONModel jsonModel = mapJsonToModel(callAPI(coordinates));
        return jsonModel;
    }

    /**
     * Method that sends the request to the google API
     *
     * @author Edward Deen
     * @param address
     * @return
     */
    private String callAPI(String address) {
        Client client = ClientBuilder.newClient();
        return client.target("https://maps.googleapis.com/maps/api/" +
                "geocode/json?address=" + address + "&key=AIzaSyD5kY3qkbU6tYmQwoExrjTFIuKQ5tz4PTQ").request().get(String.class);

    }

    /**
     * Method that maps the JSON string it gets
     * from the google API to a model
     *
     * @author Edward Deen
     * @param result
     * @return
     */
    private GoogleJSONModel mapJsonToModel(String result){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(result , GoogleJSONModel.class);

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
