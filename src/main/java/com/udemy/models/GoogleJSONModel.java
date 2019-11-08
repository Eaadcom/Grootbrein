package com.udemy.models;

import java.util.List;

public class GoogleJSONModel {
    public List<String> destination_addresses;
    public List<String> origin_addresses;
    public List<RowsModel> rows;
    public String status;

    public List<String> getDestination_addresses(){
        return destination_addresses;
    }

    public List<String> getOrigin_adresses(){
        return origin_addresses;
    }

    public List<RowsModel> getRows(){
        return rows;
    }

    public String getStatus(){
        return status;
    }
}