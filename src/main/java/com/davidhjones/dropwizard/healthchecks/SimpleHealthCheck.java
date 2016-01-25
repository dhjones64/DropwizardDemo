package com.davidhjones.dropwizard.healthchecks;


import com.codahale.metrics.health.HealthCheck;


public class SimpleHealthCheck extends HealthCheck {
	private final String applicationName;
	private final String developer;

	public SimpleHealthCheck(String applicationName, String developer) {
		this.applicationName = applicationName;
		this.developer = developer;
	}

	@Override
	protected Result check() throws Exception {

		if (!this.applicationName.equals("DropwizardDemo")) {
			return Result.unhealthy("Application name is not correct.");
		}
		if (!this.developer.equals("Dave Jones")) {
			return Result.unhealthy("Developer name is not correct.");
		}
		return Result.healthy();
	}
}