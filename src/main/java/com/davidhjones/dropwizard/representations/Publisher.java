package com.davidhjones.dropwizard.representations;


import com.fasterxml.jackson.annotation.*;


public class Publisher implements Comparable<Publisher> {
	private final int id;
	private final String companyName;
	private final String contactName;
	private final String city;

	@JsonCreator
	public Publisher(
			@JsonProperty("id") int id,
			@JsonProperty("companyName") String companyName,
			@JsonProperty("contactName") String contactName,
			@JsonProperty("city") String city) {
		this.id = id;
		this.companyName = companyName;
		this.contactName = contactName;
		this.city = city;
	}

	@JsonProperty
	public int getId() {
		return id;
	}

	@JsonProperty
	public String getCompanyName() {
		return companyName;
	}

	@JsonProperty
	public String getContactName() {
		return contactName;
	}

	@JsonProperty
	public String getCity() {
		return city;
	}

	@Override
	public String toString() {
		return "Publisher ID: " + getId() + " " + getCompanyName();
	}


	public int compareTo(Publisher o) {
		return this.getId() - o.getId();
	}
}
