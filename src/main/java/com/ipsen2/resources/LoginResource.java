package com.ipsen2.resources;


import com.ipsen2.api.Login;
import com.ipsen2.api.Mapper.LoginMapper;
import com.ipsen2.api.Person;
import com.ipsen2.db.UserDAO;
import com.ipsen2.services.JWTService;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
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
    JWTService jwtService = new JWTService();

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
    public Response getPersonLogin(@Valid Login login, @Context HttpHeaders headers){
        if (userDao.findByEmail(login.getEmail()) != null) {
            if (userDao.findByEmail(login.getEmail()).getPassword().equals(login.getPassword())) {
                //System.out.println(jwtService.verifyJWT(headers.getRequestHeaders().getFirst("Authorization")));
                Person person = userDao.findByEmail(login.getEmail());
                person.setJwt(jwtService.buildJWT(person));
                return Response
                        .ok(person)
                        .build();
            }
            else {
                return Response.status(403).build();
            }
        }
        else {
        return Response.status(405).build();
        }
    }
}
