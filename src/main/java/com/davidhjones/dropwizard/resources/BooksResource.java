package com.davidhjones.dropwizard.resources;


import com.davidhjones.dropwizard.repos.BookRepository;
import com.davidhjones.dropwizard.representations.Book;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;


@Path("books")
@Produces(MediaType.APPLICATION_JSON)
public class BooksResource {

	private final BookRepository bookRepository = new BookRepository();

	@GET
	public Response books() {

		ArrayList<Book> books = bookRepository.getAll();

		return Response.ok(books).build();
	}

	@GET
	@Path("/{id}")
	public Response getBook(@PathParam("id") int id) {

		Book book = bookRepository.getById(id);
		if (book != null) {
			return Response.ok(book).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

	}


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createBook(@Valid Book b) {
		bookRepository.create(b);
		return Response.status(Response.Status.CREATED)
				.header("Location", "books/" + b.getId())
				.build();
	}


	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateBook(@Valid Book b) {
		try {
			bookRepository.update(b);
			return Response.status(Response.Status.ACCEPTED).build();
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

	}


	@DELETE
	@Path("/{id}")
	public Response updateBook(@PathParam("id") int id) {
		try {
			bookRepository.delete(id);
			return Response.status(Response.Status.NO_CONTENT).build();
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

}
