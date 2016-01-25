package com.davidhjones.dropwizard.representations;


import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;


public class Author implements Comparable<Author> {

	private final int id;
	private final String name;
	private final int age;
	private final ArrayList<Book> books;

	@JsonCreator
	public Author(
			@JsonProperty("id") int id,
			@JsonProperty("name") String name,
			@JsonProperty("age") int age,
			@JsonProperty("books") ArrayList<Book> books) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.books = books;
	}

	@JsonProperty
	public int getId() {
		return id;
	}

	@JsonProperty
	public String getName() {
		return name;
	}

	@JsonProperty
	public int getAge() {
		return age;
	}

	@JsonProperty
	public ArrayList<Book> getBooks() {
		return books;
	}

	public int compareTo(Author o) {
		return this.getId() - o.getId();
	}
}
