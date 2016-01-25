package com.davidhjones.dropwizard;


import com.davidhjones.dropwizard.healthchecks.SimpleHealthCheck;
import com.davidhjones.dropwizard.resources.*;
import io.dropwizard.Application;
import io.dropwizard.setup.*;


public class BookStoreApplication extends Application<BookStoreConfiguration> {
	public static void main(String[] args) throws Exception {
		new BookStoreApplication().run(args);
	}

	@Override
	public String getName() {
		return "bookstore";
	}

	@Override
	public void initialize(Bootstrap<BookStoreConfiguration> bootstrap) {
		// nothing to do yet
	}

	@Override
	public void run(BookStoreConfiguration configuration, Environment environment) {

		final SimpleHealthCheck healthCheck = new SimpleHealthCheck(configuration.getApplicationName(), configuration.getDeveloper());
		environment.healthChecks().register("Simple heath check result", healthCheck);

		final AuthorsResource authorsResource = new AuthorsResource();
		environment.jersey().register(authorsResource);

		final BooksResource bookResource = new BooksResource();
		environment.jersey().register(bookResource);

		final PublishersResource publishersResource = new PublishersResource();
		environment.jersey().register(publishersResource);



	}
}
