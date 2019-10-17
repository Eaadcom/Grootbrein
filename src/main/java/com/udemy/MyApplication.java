package com.udemy;

import com.udemy.DAO.UserDAO;
import com.udemy.resources.CarResource;
import com.udemy.resources.UserResource;
import io.dropwizard.client.HttpClientBuilder;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.Application;

import org.apache.http.client.HttpClient;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.skife.jdbi.v2.DBI;

import javax.ws.rs.client.Client;

public class MyApplication extends Application<ApplicationConfiguration> {

    public static void main(String[] args) throws Exception {
        new MyApplication().run(args);
    }


    @Override
    public String getName() {
        return "DropBookmarks";
    }

    @Override
    public void initialize(final Bootstrap<ApplicationConfiguration> bootstrap) {
        // TODO: application initialization
    }
    @Override
    public void run(ApplicationConfiguration configuration, Environment environment) throws Exception {
       // final DBIFactory factory = new DBIFactory();
      //  final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "h2");

       // final UserDAO userDAO = jdbi.onDemand(UserDAO.class);


        //final UserResource personResource = new UserResource(userDAO);


        environment.jersey().register(new CarResource());


        //final Client client = new JerseyClientBuilder(environment).using(configuration.getJerseyClientConfiguration())
        //       .build(getName());
        //environment.jersey().register(new CarResource(client));
    }



}
