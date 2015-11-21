package com.gtnow.backend1.endpoint;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.appengine.repackaged.org.joda.time.DateTime;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.gtnow.backend1.OfyService;
import com.gtnow.backend1.entity.Event;
// import com.gtnow.backend1.object.Location;

/**
 * Endpoints for Event.
 */
@Path("/api/events")
public class EventEndpoint {
	/**
	 * Returns a List of all Events.
	 * @return A List of all Events.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Event> getAllEvents() {
		Objectify ofy = OfyService.ofy();
		return ofy.load().type(Event.class).list();
	}
	
	/**
	 * Retrieve an Event by id.
	 * @param eventId	The id of the Event to be retrieved.
	 * @return			The retrieved Event.
	 */
	@GET
	@Path("{eventId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Event getEvent(@PathParam("eventId") Long eventId) {
		Objectify ofy = OfyService.ofy();
		return ofy.load().type(Event.class).id(eventId).now();
	}
	
	/**
	 * Updates an Event.
	 * @param eventId	The id of the Event to be updated.
	 * @param event		The new Event.
	 * @return			The updated Event.
	 */
	@PUT
	@Path("{eventId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Event updateEvent(@PathParam("eventId") Long eventId,
			Event event) {
		Objectify ofy = OfyService.ofy();
		Key<Event> key = ofy.save().entity(event).now();
        return ofy.load().key(key).now();
	}
	
	/**
	 * Deletes an Event from the datastore.
	 * @param eventId	The id of the Event to be deleted.
	 * @return			The Event that has just been deleted.
	 */
	@DELETE
	@Path("{eventId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Event deleteEvent(@PathParam("eventId") Long eventId) {
		Objectify ofy = OfyService.ofy();
		Event event = ofy.load().type(Event.class).id(eventId).now();
        ofy.delete().entity(event).now();
        return event;
	}
}
