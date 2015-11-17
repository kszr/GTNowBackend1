package com.gtnow.backend1.endpoint;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.gtnow.backend1.OfyService;
import com.gtnow.backend1.entity.Building;
import com.gtnow.backend1.entity.User;
import com.gtnow.backend1.object.Location;

/**
 * Endpoints for Building.
 */
@Path("/api/buildings")
public class BuildingEndpoint {
	/**
	 * Get all the Buildings in the datastore.
	 * @return A List of all Buildings in the datastore.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Building> getAllBuildings() {
		Objectify ofy = OfyService.ofy();
        return ofy.load().type(Building.class).list();
	}
	
	/**
	 * Retrieve a Building object from the datastore by buildingId.
	 * @param  buildingId	The buildingId of the Building being retrieved.
	 * @return				The retrieved Building.
	 */
	@GET
	@Path("{buildingId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Building getBuilding(@PathParam("buildingId") Long buildingId) {
		Objectify ofy = OfyService.ofy();
		return ofy.load().type(Building.class).id(buildingId).now();
	}
}
