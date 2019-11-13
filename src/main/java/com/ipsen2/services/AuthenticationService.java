package com.ipsen2.services;

import com.udemy.DropWizardApplication;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * This class facilitates the authentication between our clientside application and dropwizard server.
 *
 * @author Edward Deen
 * @version 07-11-2019
 */

public class AuthenticationService implements ContainerRequestFilter {

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

    /**
     * @author Salah Abdulkader
     * @param context
     * @throws IOException
     */

    @Override
    public void filter(ContainerRequestContext context) throws IOException {
        // Check if the user gave a Authorization key in the header
        if (!context.getHeaders().containsKey("Authorization")) {
            Exception cause = new IllegalArgumentException("Token not provided");
            throw new WebApplicationException(cause, Response.Status.UNAUTHORIZED);
        }

        String token = context.getHeaders().getFirst("Authorization");

        // Check if the token is not empty
        if (token.equals("")) {
            Exception cause = new IllegalArgumentException("Token not provided");
            throw new WebApplicationException(cause, Response.Status.UNAUTHORIZED);
        }

        System.err.println(DropBookmarksApplication.tokenProvider.verifyToken(token));

        // Validate the token
        if (!DropBookmarksApplication.tokenProvider.verifyToken(token)) {
            Exception cause = new IllegalArgumentException("Token not provided");
            throw new WebApplicationException(cause, Response.Status.UNAUTHORIZED);
        }

//        // Save user in current session
//        long id = DropBookmarksApplication.tokenProvider.getDecodedJWT(token).getClaim("user_id").asLong();
//        Person.setAuthUser(
//                UserService.getUserById(id)
//        );
    }



}
