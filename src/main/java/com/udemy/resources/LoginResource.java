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

@Path("/login")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@RegisterMapper(LoginMapper.class)
public class LoginResource {
    UserDAO userDao;

    public LoginResource(UserDAO userDao) {
        this.userDao = userDao;
    }

    @POST
    public Response getPersonLogin(@Valid Login login){
        System.out.println(userDao.findByEmail(login.getEmail()));
        if (userDao.findByEmail(login.getEmail()) != null) {
            if (userDao.findByEmail(login.getEmail()).getPassword().equals(login.getPassword())) {
                System.out.println(userDao.findByEmail(login.getEmail()));
                return Response.ok(userDao.findByEmail(login.getEmail())).build();
            }
            else {
                return Response.status(409).build();
            }
        }
        return null;
    }

}
