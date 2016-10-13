package com.johnbarleycorn.locationtracker.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

@Component
@Path("/check")
public class CheckResource {

	@GET
	@Produces("text/plain")
	public String doCheck() {
		return "Service is up and running!";
	}
}
