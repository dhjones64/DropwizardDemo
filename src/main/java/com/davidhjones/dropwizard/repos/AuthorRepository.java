package com.davidhjones.dropwizard.repos;


import com.davidhjones.dropwizard.representations.*;

import java.util.*;


public class AuthorRepository implements BookStoreRepository<Author> {

	private final ArrayList<Author> authors;


	public AuthorRepository() {

		BookRepository bookRepository = new BookRepository();
		authors = new ArrayList<Author>();

		ArrayList<Book> books1 = new ArrayList<Book>();
		books1.add(bookRepository.getById(1));
		books1.add(bookRepository.getById(2));
		authors.add(new Author(1, "Dave", 30, books1));

		ArrayList<Book> books2 = new ArrayList<Book>();
		books2.add(bookRepository.getById(3));
		authors.add(new Author(2, "Tom", 55, books2));

		ArrayList<Book> books3 = new ArrayList<Book>();
		books3.add(bookRepository.getById(4));
		books3.add(bookRepository.getById(5));
		books3.add(bookRepository.getById(6));

		authors.add(new Author(4, "Jimmy", 24, books3));
		authors.add(new Author(5, "Franklin", 42, null));

	}


	public ArrayList<Author> getAll() {
		Collections.sort(authors);
		return authors;
	}


	public Author getById(int id) {
		ArrayList<Author> authors = getAll();

		for (Author a : authors) {
			if (a.getId() == id) {
				return a;
			}
		}
		return null;
	}

	public void create(Author o) {
		authors.add(o);
	}

	public void update(Author o) throws Exception {
		Author match = getById(o.getId());
		if (match == null) {
			throw new Exception("Publisher not found");
		}
		authors.remove(match);
		authors.add(o);
	}

	public void delete(int id) throws Exception {
		Author match = getById(id);
		if (match == null) {
			throw new Exception("Publisher not found");
		}
		authors.remove(match);
	}
}
