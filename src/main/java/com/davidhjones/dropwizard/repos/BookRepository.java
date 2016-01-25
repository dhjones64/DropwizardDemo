package com.davidhjones.dropwizard.repos;


import com.davidhjones.dropwizard.representations.Book;

import java.util.*;


public class BookRepository implements BookStoreRepository<Book> {

	private final ArrayList<Book> books;

	public BookRepository() {

		PublisherRepository publisherRepository = new PublisherRepository();

		books = new ArrayList<Book>();
		books.add(new Book(1, "I Know REST", "Fiction", publisherRepository.getById(2)));
		books.add(new Book(2, "Green Eggs and Ham", "Children", publisherRepository.getById(2)));
		books.add(new Book(3, "Code Complete 2nd Edition", "Computer", publisherRepository.getById(1)));
		books.add(new Book(4, "Windows 10: The Missing Manual", "Computer", publisherRepository.getById(3)));
		books.add(new Book(5, "Rick Steve's Guide to Paris", "Travel", publisherRepository.getById(4)));
		books.add(new Book(6, "Cooking for Dummies", "Non-fiction", publisherRepository.getById(5)));
	}

	public ArrayList<Book> getAll() {

		Collections.sort(books);
		return books;
	}


	public Book getById(int id) {
		ArrayList<Book> books = getAll();

		for (Book b : books) {
			if (b.getId() == id) {
				return b;
			}
		}
		return null;
	}

	public void create(Book o) {
		books.add(o);
	}

	public void update(Book o) throws Exception {
		Book match = getById(o.getId());
		if (match == null) {
			throw new Exception("Publisher not found");
		}
		books.remove(match);
		books.add(o);
	}

	public void delete(int id) throws Exception {
		Book match = getById(id);
		if (match == null) {
			throw new Exception("Publisher not found");
		}
		books.remove(match);
	}
}

