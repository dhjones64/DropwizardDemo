package com.davidhjones.dropwizard.representations;


import com.fasterxml.jackson.annotation.*;


public class Book implements Comparable<Book> {

	private final int id;
	private final String title;
	private final String Genre;
	private final Publisher publisher;

	@JsonCreator
	public Book(
			@JsonProperty("id") int id,
			@JsonProperty("title") String title,
			@JsonProperty("genre") String genre,
			@JsonProperty("publisher") Publisher publisher) {
		this.id = id;
		this.title = title;
		Genre = genre;
		this.publisher = publisher;
	}

	@JsonProperty
	public int getId() {
		return id;
	}

	@JsonProperty
	public String getTitle() {
		return title;
	}

	@JsonProperty
	public String getGenre() {
		return Genre;
	}

	@JsonProperty
	public Publisher getPublisher() {
		return publisher;
	}

	public int compareTo(Book o) {
		return this.getId() - o.getId();
	}
}
