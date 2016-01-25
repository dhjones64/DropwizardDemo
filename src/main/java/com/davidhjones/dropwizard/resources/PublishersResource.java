package com.davidhjones.dropwizard.resources;


import com.davidhjones.dropwizard.repos.PublisherRepository;
import com.davidhjones.dropwizard.representations.Publisher;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;


@Path("publishers")
@Produces(MediaType.APPLICATION_JSON)
public class PublishersResource {

	private final PublisherRepository publisherRepository = new PublisherRepository();

	@GET
	public Response publishers() {

		ArrayList<Publisher> publishers = publisherRepository.getAll();

		return Response.ok(publishers).build();

	}

	@GET
	@Path("/{id}")
	public Response getPublisher(@PathParam("id") int id) {

		Publisher publisher = publisherRepository.getById(id);
		if (publisher != null) {
			return Response.ok(publisher).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

	}


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createPublisher(@Valid Publisher p) {
		publisherRepository.create(p);
		return Response.status(Response.Status.CREATED)
				.header("Location", "publishers/" + p.getId())
				.build();
	}


	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatePublisher(@Valid Publisher p) {
		try {
			publisherRepository.update(p);
			return Response.status(Response.Status.ACCEPTED).build();
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

	}


	@DELETE
	@Path("/{id}")
	public Response updatePublisher(@PathParam("id") int id) {
		try {
			publisherRepository.delete(id);
			return Response.status(Response.Status.NO_CONTENT).build();
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

}
