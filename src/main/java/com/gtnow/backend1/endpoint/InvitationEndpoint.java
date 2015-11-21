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
import com.gtnow.backend1.entity.Invitation;

/**
 * Endpoints for the Invitation entity.
 */
@Path("api/invites")
public class InvitationEndpoint {
	/**
	 * Adds a new invitation to the datastore.
	 * @param  invitation	The Invitation to be added.
	 * @return				The Invitation that has just been added.
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Invitation createNewInvitation(Invitation invitation) {
		Objectify ofy = OfyService.ofy();
		Key<Invitation> key = ofy.save().entity(invitation).now();
		return ofy.load().key(key).now();
	}
	
	/**
	 * Returns a list of all Invitations in the datastore.
	 * @return	A list of all invitations in the datastore.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Invitation> getAllInvitations() {
		Objectify ofy = OfyService.ofy();
		return ofy.load().type(Invitation.class).list();
	}
	
	/**
	 * Gets an Invitation by id.
	 * @param  invitationId		The id of the Invitation being retrieved.
	 * @return					The retrieved Invitation.
	 */
	@GET
	@Path("{invitationId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Invitation getInvitationById(@PathParam("invitationId") Long invitationId) {
		Objectify ofy = OfyService.ofy();
		return ofy.load().type(Invitation.class).id(invitationId).now();
	}
	
	/**
	 * Updates an Invitation.
	 * @param  invitationId		The id of the Invitation to be updated.
	 * @param  invitation		The updated Invitation.
	 * @return					The updated Invitation.
	 */
	@PUT
	@Path("{invitationId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Invitation updateInvitation(@PathParam("invitationId") Long invitationId,
			Invitation invitation) {
		Objectify ofy = OfyService.ofy();
        Key<Invitation> key = ofy.save().entity(invitation).now();
        return ofy.load().key(key).now();
	}
	
	/**
	 * Deletes an Invitation from the datastore.
	 * @param  invitationId		The id of the Invitation to be deleted.
	 * @return					The Invitation that has just been deleted.
	 */
	@DELETE
	@Path("{invitationId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Invitation deleteInvitation(@PathParam("invitationId") Long invitationId) {
		Objectify ofy = OfyService.ofy();
		Invitation invitation = ofy.load().type(Invitation.class).id(invitationId).now();
        ofy.delete().entity(invitation).now();
        return invitation;
	}
}
