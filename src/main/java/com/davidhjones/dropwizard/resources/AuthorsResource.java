package com.davidhjones.dropwizard.resources;


import com.davidhjones.dropwizard.repos.AuthorRepository;
import com.davidhjones.dropwizard.representations.Author;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;


@Path("authors")
@Produces(MediaType.APPLICATION_JSON)
public class AuthorsResource {

	private final AuthorRepository authorRepository = new AuthorRepository();

	@GET
	public Response getAuthors() {

		ArrayList<Author> authors = authorRepository.getAll();

		return Response.ok(authors).build();
	}

	@GET
	@Path("/{id}")
	public Response getAuthor(@PathParam("id") int id) {

		Author author = authorRepository.getById(id);
		if (author != null) {
			return Response.ok(author).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

	}


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createAuthor(@Valid Author a) {
		authorRepository.create(a);
		return Response.status(Response.Status.CREATED)
				.header("Location", "authors/" + a.getId())
				.build();
	}


	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateAuthor(@Valid Author a) {
		try {
			authorRepository.update(a);
			return Response.status(Response.Status.ACCEPTED).build();
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

	}


	@DELETE
	@Path("/{id}")
	public Response updateAuthor(@PathParam("id") int id) {
		try {
			authorRepository.delete(id);
			return Response.status(Response.Status.NO_CONTENT).build();
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

}
