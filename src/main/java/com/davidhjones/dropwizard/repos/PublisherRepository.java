package com.davidhjones.dropwizard.repos;


import com.davidhjones.dropwizard.representations.Publisher;

import java.util.*;


public class PublisherRepository implements BookStoreRepository<Publisher> {

	private final ArrayList<Publisher> publishers;

	public PublisherRepository() {
		publishers = new ArrayList<Publisher>();
		publishers.add(new Publisher(1, "RandRange House", "Dave Jones", "New York"));
		publishers.add(new Publisher(2, "Books R Us", "Dave Jones", "Pittsburg"));
		publishers.add(new Publisher(3, "Peach Pit", "Dave Jones", "Chicago"));
		publishers.add(new Publisher(4, "PBS", "Dave Jones", "Toronto"));
		publishers.add(new Publisher(5, "Book Co.", "Dave Jones", "Huston"));
	}

	public ArrayList<Publisher> getAll() {
		Collections.sort(publishers);
		return publishers;
	}

	public Publisher getById(int id) {

		for (Publisher p : publishers) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}

	public void create(Publisher o) {
		publishers.add(o);
	}


	public void update(Publisher o) throws Exception {
		Publisher match = getById(o.getId());
		if (match == null) {
			throw new Exception("Publisher not found");
		}
		publishers.remove(match);
		publishers.add(o);
	}

	public void delete(int id) throws Exception {

		Publisher match = getById(id);
		if (match == null) {
			throw new Exception("Publisher not found");
		}
		publishers.remove(match);
	}


}


