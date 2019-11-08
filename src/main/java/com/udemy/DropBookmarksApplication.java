package com.udemy;

import com.udemy.checks.DatabaseHealthCheck;
import com.udemy.db.*;
import com.udemy.resources.*;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.forms.MultiPartBundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
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

    /**
     * Initialize Bundles
     *
     * @author Salah Abdulkader
     * @since 008-11-2019
     * @param bootstrap
     */

    @Override
    public void initialize(Bootstrap<DropBookmarksConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<DropBookmarksConfiguration>(){
            @Override
            public DataSourceFactory getDataSourceFactory(final DropBookmarksConfiguration config) {
                return config.getDataSourceFactory();
            }
        });
        bootstrap.addBundle(new MultiPartBundle());
    }


    @Override
    public void run(final DropBookmarksConfiguration config,
                    final Environment environment) throws ClassNotFoundException {

        final DBIFactory factory = new DBIFactory();
        final DBI db = factory.build(environment,config.getDataSourceFactory(),"mysql");

        final UserDAO personDAO = db.onDemand(UserDAO.class);
        final ProjectDAO projectDao = db.onDemand(ProjectDAO.class);
        final TripDAO tripDAO = db.onDemand(TripDAO.class);
        final UserHasProjectDAO userhasprojDAO = db.onDemand(UserHasProjectDAO.class);
        final CarDAO carDAO = db.onDemand(CarDAO.class);


        final UserResource personResource = new UserResource(personDAO, userhasprojDAO);
        final ProjectResource projectResource = new ProjectResource(projectDao);
        final TripsResource tripsResource = new TripsResource(tripDAO);
        final CarResource carResource = new CarResource(carDAO);
        final LoginResource loginResource = new LoginResource(personDAO);
        final UserHasProjectResource userHasProjectResource = new UserHasProjectResource(userhasprojDAO);


        environment.jersey().register(personResource);
        environment.jersey().register(projectResource);
        environment.jersey().register(tripsResource);
        environment.jersey().register(carResource);
        environment.jersey().register(loginResource);
        environment.jersey().register(userHasProjectResource);
        /**
         * @author Salah Abdulkader
         * Health Checks
         */
        environment.healthChecks().register("checks",
                new DatabaseHealthCheck(db, config.getDataSourceFactory().getValidationQuery()));


    }

}
