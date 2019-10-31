package com.udemy;

import com.udemy.resources.UserResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
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
    public void run(final DropBookmarksConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        //environment.jersey().register(new HelloResource());

        //Here we added REST Resource


               //Now we added REST Client Resource named RESTClientController
        //JerseyClientBuilder builder = new JerseyClientBuilder(environment);
      //  Client client = builder.using(configuration.getJerseyClientConfiguration()).build("MyClient");
        //final Client client = new JerseyClientBuilder(environment).using(configuration.getJerseyClientConfiguration()).build(getName());
      //  environment.jersey().register(new ClientResource(client));
        environment.jersey().register(new UserResource());


    }

}
