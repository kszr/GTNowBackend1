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
import com.gtnow.backend1.entity.User;
import com.gtnow.backend1.entity.Group;
import com.gtnow.backend1.object.Location;


/**
 * Endpoints for the Group entity.
 */
@Path("/api/group")
public class GroupEndpoint {
    /**
     * Add a new Group object to the datastore.
     * @param  group	The Group object that is to be added to the datastore.
     * @return          The Group that has just been added.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Group createUser(Group group) {
        Objectify ofy = OfyService.ofy();
        Key<Group> key = ofy.save().entity(group).now();
        return ofy.load().key(key).now();
    }
    
    /**
     * Gets a Group by groupId from the datastore.
     * @param  groupId	The groupId of the Group to be retrieved.
     * @return			The requested Group.
     */
    @GET
    @Path("{groupId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Group getGroupInformation(@PathParam("groupId") String groupId) {
        Objectify ofy = OfyService.ofy();
    	return ofy.load().type(Group.class).id(groupId).now();
    }
    
    /**
     * Updates a Group's information
     * @param  groupId	The groupId of the Group being updated.
     * @param  group	The new Group.
     * @return			The updated Group.
     */
    @PUT
    @Path("{groupId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Group updateGroupInformation(@PathParam("groupId") String groupId, Group group) {
        Objectify ofy = OfyService.ofy();
        Key<Group> key = ofy.save().entity(group).now();
        return ofy.load().key(key).now();
    }
    
    /**
     * Gets all the members of a Group.
     * @param  groupId	The groupId of the Group being requested
     * @return			A List of all Users in that Group.
     * 
     * @TODO Everything, please. [Invitation]
     */
    @GET
    @Path("{groupId}/users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllGroupMembers(@PathParam("groupId") String groupId) {
        Objectify ofy = OfyService.ofy();
    	return ofy.load().type(Group.class).id(groupId).type(User.class).list();
    }
    
    /**
     * Deletes a User from a Group.
     * @param  groupId	The groupId of the Group being accessed.
     * @param  userId	The userId of the User being deleted.
     * @return			The deleted User.
     * 
     * @TODO Everything [Invitation].
     */
    @DELETE
    @Path("{groupId}/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public User deleteGroupMember(@PathParam("groupId") String groupId, @PathParam("userId") String userId) {
        Objectify ofy = OfyService.ofy();
        User user = ofy.load().type(Group.class).id(groupId).type(User.class).id(userId).now();
        ofy.delete().entity(user).now();
    	return user;
    }
    
    /**
     * Adds a User directly to a Group.
     * @param  groupId	The groupId of the Group being accessed.
     * @param  user		The User to be added to the Group.
     * @return			The User that has just been added.
     * 
     * @TODO			Find a way to add user directly to group... [Invitation]
     */
    @PUT
    @Path("{groupId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User addUserToGroup(@PathParam("groupId") String groupId, User user) {
    	Objectify ofy = OfyService.ofy();
        ofy.load().type(Group.class).id(groupId).save().entity(user).now();
        return user;
    }
}
