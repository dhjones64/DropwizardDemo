package com.davidhjones.dropwizard;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;


public class BookStoreConfiguration extends Configuration {

	@NotEmpty
	private String applicationName;

	@NotEmpty
	private String developer;

	@JsonProperty
	public String getApplicationName() {
		return applicationName;
	}

	@JsonProperty
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	@JsonProperty
	public String getDeveloper() {
		return developer;
	}

	@JsonProperty
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
}
