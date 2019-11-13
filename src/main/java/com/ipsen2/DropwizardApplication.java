package com.ipsen2;

import com.ipsen2.checks.DatabaseHealthCheck;
import com.ipsen2.db.*;
import com.ipsen2.resources.*;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.forms.MultiPartBundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class DropwizardApplication extends Application<DropwizardConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropwizardApplication().run(args);

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
    public void initialize(Bootstrap<DropwizardConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<DropwizardConfiguration>(){
            @Override
            public DataSourceFactory getDataSourceFactory(final DropwizardConfiguration config) {
                return config.getDataSourceFactory();
            }
        });
        bootstrap.addBundle(new MultiPartBundle());
    }


    @Override
    public void run(final DropwizardConfiguration config,
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
