package com.ipsen2;

import com.ipsen2.checks.DatabaseHealthCheck;
import com.ipsen2.db.*;
import com.ipsen2.resources.*;
import com.udemy.Provider.TokenProvider;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.forms.MultiPartBundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.skife.jdbi.v2.DBI;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class DropwizardApplication extends Application<DropwizardConfiguration> {

    public static TokenProvider tokenProvider;


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

        /**
         * @author Salah Abulkader
         * Initializables
         */
        tokenProvider = new TokenProvider();

        /**
         * @author Edward Deen
         */
        configureCors(environment);
    }

    /**
     * @author Edward Deen
     */
    private void configureCors(Environment environment) {
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin,Authorization");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        cors.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM, "true");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    }
}
