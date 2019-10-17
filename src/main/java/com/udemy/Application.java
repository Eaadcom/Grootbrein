package com.udemy;

import com.udemy.DAO.UserDAO;
import com.udemy.resources.UserResource;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.skife.jdbi.v2.DBI;

public class Application extends io.dropwizard.Application<ApplicationConfiguration> {

    @Override
    public void run(ApplicationConfiguration configuration, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "h2");

        final UserDAO userDAO = jdbi.onDemand(UserDAO.class);


        final UserResource personResource = new UserResource(userDAO);

        final Client client = new JerseyClientBuilder(environment).using(configuration.getJerseyClientConfiguration())
                .build(getName());
        final String firebaseKey = configuration.getFirebaseKey();

        environment.jersey().register(new FlagResource(flagDAO, nearbyFlagDAO, playerDAO, client, firebaseKey));
        environment.jersey().register(new PlayerResource(playerDAO, flagDAO));
    }




}
