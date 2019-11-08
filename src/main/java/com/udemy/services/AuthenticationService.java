package com.udemy.services;

import com.sun.deploy.net.HttpResponse;

/**
 * This class facilitates the authentication between our clientside application and dropwizard server.
 *
 * @author Edward Deen
 * @version 07-11-2019
 */

public class AuthenticationService {

    /**
     * This method compares the GUID key it gets to the GUID key in use for authentication
     * and returns a boolean based on the result.
     *
     * @author Edward Deen
     * @version 07-11-2019
     */
    public boolean authenticate(String key){
        String GUIDKey = "dda32ac4-ba5f-499d-9398-60d0cfa09a3f";
        if (key.equals(GUIDKey)){
            return true;
        } else {
            return false;
        }
    }
}
