package com.udemy;

import com.udemy.db.*;
import com.udemy.resources.CarResource;
import com.udemy.resources.ProjectResource;
import com.udemy.resources.TripsResource;
import com.udemy.resources.UserResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class DropBookmarksApplication extends Application<DropBookmarksConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropBookmarksApplication().run(args);

    }

    @Override
    public String getName() {
        return "DropBookmarks";
    }

    @Override
    public void initialize(final Bootstrap<DropBookmarksConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DropBookmarksConfiguration config,
                    final Environment environment) throws ClassNotFoundException {
        environment.jersey().register(new HelloResource());

        final DBIFactory factory = new DBIFactory();
        final DBI db = factory.build(environment,config.getDataSourceFactory(),"mysql");

        final UserDAO personDAO = db.onDemand(UserDAO.class);
        final ProjectDAO projectDao = db.onDemand(ProjectDAO.class);
        final TripDAO tripDAO = db.onDemand(TripDAO.class);
        final UserHasProjectDAO userhasprojDAO = db.onDemand(UserHasProjectDAO.class);
        final UserHasCarDAO userHasCarDAO = db.onDemand(UserHasCarDAO.class);


        final UserResource personResource = new UserResource(personDAO, userhasprojDAO);
        final ProjectResource projectResource = new ProjectResource(projectDao);
        final TripsResource tripsResource = new TripsResource(tripDAO);
        final CarResource carResource = new CarResource(userHasCarDAO);


        environment.jersey().register(personResource);
        environment.jersey().register(projectResource);
        environment.jersey().register(tripsResource);
        environment.jersey().register(carResource);
    }

}
