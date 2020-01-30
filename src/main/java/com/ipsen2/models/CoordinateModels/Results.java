package com.ipsen2.models.CoordinateModels;

import java.util.List;

/**.
 * @author Edward Deen
 * @version 08-11-2019
 */
public class Results {
    public List<AddressComponents> address_components;
    public String formatted_address;
    public Geometry geometry;
    public String place_id;
    public List<String> types;
    public boolean partial_match;
    public Plus_code plus_code;
}
