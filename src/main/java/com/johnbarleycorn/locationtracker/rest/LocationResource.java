package com.johnbarleycorn.locationtracker.rest;

import java.net.URI;
import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.johnbarleycorn.locationtracker.persistent.repository.LocationEntity;
import com.johnbarleycorn.locationtracker.persistent.repository.LocationRepository;
import com.johnbarleycorn.locationtracker.persistent.repository.UserEntity;

@Component
@Path("/location")
@Produces(MediaType.APPLICATION_JSON)
public class LocationResource {
	
	@Inject
	private LocationRepository locationRepository;
	
    @Context
    private UriInfo uriInfo;

	@GET
	@Produces("application/json")
	public Page<LocationEntity> getLocation(
			@QueryParam("userId") @DefaultValue("dummy") String userId, 
			@QueryParam("page") @DefaultValue("0") int page,
			@QueryParam("size") @DefaultValue("50") int size) {
				return locationRepository.findByUser(new PageRequest(page, size), new UserEntity(userId));
		
	}
	
	@GET
	@Path("/all")
	@Produces("application/json")
	public List<LocationEntity> getLocation(@QueryParam("userId") @DefaultValue("dummy") String userId) {
		return locationRepository.findAllByUser(new UserEntity(userId));

	}
	
	@PUT
	@Path("/updatelocation")
	@Consumes("application/json")
	public Response updateLocation(final LocationEntity location) {
		location.setServerTs(new Timestamp(System.currentTimeMillis()));
		LocationEntity savedLocation = locationRepository.save(location);
		URI uri = uriInfo.getAbsolutePathBuilder().path("{userId}").resolveTemplate("userId", savedLocation.getLocationId())
				.build();

		return Response.created(uri).build();

	}
}
