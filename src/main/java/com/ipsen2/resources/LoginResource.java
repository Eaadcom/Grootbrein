package com.ipsen2.resources;


import com.ipsen2.api.Login;
import com.ipsen2.api.Mapper.LoginMapper;
import com.ipsen2.db.UserDAO;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Receives the requests from the paths and calls the dao that is needed.
 * @author Melissa Basgol
 */

@Path("/login")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@RegisterMapper(LoginMapper.class)
public class LoginResource {
    UserDAO userDao;

    public LoginResource(UserDAO userDao) {
        this.userDao = userDao;
    }

    /**
     * Checks if the posted login email is in the database
     * and then checks if the password is correct
     * if it is correct it returns the user
     * @author Melissa Basgol
     */
    @POST
    public Response getPersonLogin(@Valid Login login){
        if (userDao.findByEmail(login.getEmail()) != null) {
            if (userDao.findByEmail(login.getEmail()).getPassword().equals(login.getPassword())) {
                System.out.println(userDao.findByEmail(login.getEmail()));
                return Response.ok(userDao.findByEmail(login.getEmail())).build();
            }
            else {
                return Response.status(404).build();
            }
        }
        else {
        return Response.status(404).build();

        }
    }

}