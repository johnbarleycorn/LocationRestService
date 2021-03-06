package com.johnbarleycorn.locationtracker.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(CheckResource.class);
		register(LocationResource.class);
		register(UserResource.class);
	}
}
