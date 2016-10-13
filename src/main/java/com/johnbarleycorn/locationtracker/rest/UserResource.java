package com.johnbarleycorn.locationtracker.rest;

import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.johnbarleycorn.locationtracker.persistent.repository.UserEntity;
import com.johnbarleycorn.locationtracker.persistent.repository.UserRepository;

@Component
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
	
	@Inject
	UserRepository userRepository;
	
	@GET
	public UserEntity getUser(@QueryParam("userId") @DefaultValue("dummy") String userId) {
		return userRepository.findOne(userId);
	}
}
