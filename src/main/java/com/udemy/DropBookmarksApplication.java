package com.udemy;

import com.udemy.core.DbConnection;
import com.udemy.resources.UserResource;
import io.dropwizard.Application;
import io.dropwizard.client.HttpClientBuilder;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.apache.http.client.HttpClient;
import org.glassfish.jersey.client.JerseyClient;
import org.skife.jdbi.v2.DBI;

import javax.ws.rs.client.Client;

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
                    final Environment environment) {
        // TODO: implement application
        environment.jersey().register(new HelloResource());

        //environment.jersey().register(new UserResource());
        //Here we added REST Resource


        //final Client client = new JerseyClientBuilder(environment).using(config.getJerseyClientConfiguration())
        //        .build(getName());
        environment.jersey().register(new UserResource());




    }

}
