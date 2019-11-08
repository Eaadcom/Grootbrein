package com.udemy.resources;


import com.udemy.api.Login;
import com.udemy.api.Mapper.LoginMapper;
import com.udemy.api.Mapper.PersonMapper;
import com.udemy.db.UserDAO;
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
        System.out.println(userDao.findByEmail(login.getEmail()));
        if (userDao.findByEmail(login.getEmail()) != null) {
            if (userDao.findByEmail(login.getEmail()).getPassword().equals(login.getPassword())) {
                System.out.println(userDao.findByEmail(login.getEmail()));
                return Response.ok(userDao.findByEmail(login.getEmail())).build();
            }
            else {
                return Response.status(404).build();
            }
        }
        return null;
    }

}
