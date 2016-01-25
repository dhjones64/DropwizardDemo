package com.davidhjones.dropwizard.repos;


import java.util.ArrayList;


interface BookStoreRepository<T> {

	ArrayList<T> getAll();

	T getById(int id);

	void create(T obj);

	void update(T obj) throws Exception;

	void delete(int id) throws Exception;

}
