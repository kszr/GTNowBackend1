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
import com.gtnow.backend1.object.Location;

/**
 * Endpoints for User.
 */
@Path("api/users")
public class UserEndpoint {
	/**
	 * Get a List of all Users from the datastore.
	 * @return A List of all Users in the datastore.
	 */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
    	Objectify ofy = OfyService.ofy();
        return ofy.load().type(User.class).list();
    }
    
    /**
     * Create a new User.
     * @param  user	The new User being added to the datastore.
     * @return		The User that has just been added to the datastore.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User saveNewUser(User user) {
    	Objectify ofy = OfyService.ofy();
        Key<User> key = ofy.save().entity(user).now();
        return ofy.load().key(key).now();
    }
    
    /**
     * Update a User's information
     * (Note: I know we defined separate endpoints to update a User's info
     * and to update a User's location specifically in our interface doc,
     * but I think it makes more sense to have just one endpoint, especially
     * considering that we are passing in an updated User object anyway.
     * -A. C.)
     * @param  id	The id of the User being updated.	
     * @param  user		An updated version of the User.
     * @return			The updated User.
     */
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User updateUser(@PathParam("id") String id,
    		User user) {
    	Objectify ofy = OfyService.ofy();
    	updateUser(user, ofy);
    	ofy.save().entity(user).now();
    	return user;
    }
    
    /**
     * A private helper function that makes sure that an existing User's attributes do not
     * get erased, if the PUT request does not contain all the JsonProperties that define
     * a User. This function is also responsible for updating the value of locationReportTime,
     * if the PUT request happens to come with values for location.
     * @param  user	The updated version of the User
     * @param  ofy  The Objectify instance
     */
    private static void updateUser(User user, Objectify ofy) {
    	//Retrieving the existing version of the User from the datastore.
    	User user2 = ofy.load().type(User.class).id(user.getid()).now();

    	//Updating the User's location and/or locationReportTime.
    	if(user.getLocation() != null) {
    		user.setLocationReportTime((new DateTime()).toString());
    	} else if(user2 != null) {
    		user.setLocationReportTime(user2.getLocationReportTime());
    		user.setLocation(user2.getLocation());
    	}

    	//Updating the User's name.
    	if(user.getName() == null)
    		user.setName(user2.getName());
    	//Updating the User's gmailId.
    	if(user.getGmailId() == null)
    		user.setGmailId(user2.getGmailId());
    }
    
    /**
     * Delete a user from the datastore.
     * @param  id	The id of the User being deleted.
     * @return		The User that has just been deleted.
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User deleteUser(@PathParam("id") String id) {
    	Objectify ofy = OfyService.ofy();
    	User user = ofy.load().type(User.class).id(id).now();
    	ofy.delete().entity(user).now();
    	return user;
    }
    
    /**
     * Retrieve a User from the datastore. 
     * @param  id	The id of the User being retrieved.
     * @return 		The retrieved User.
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") String id) {
    	Objectify ofy = OfyService.ofy();
    	return ofy.load().type(User.class).id(id).now();
    }
    
    /**
     * Get a User's location.
     * @param  id	The id of the User being requested.
     * @return			The Location of the User.
     */
    @GET
    @Path("{id}/location")
    @Produces(MediaType.APPLICATION_JSON)
    public Location getUserLocation(@PathParam("id") String id) {
    	Objectify ofy = OfyService.ofy();
    	User user = ofy.load().type(User.class).id(id).now();
    	return user.getLocation();
    }
    //TODO
    /*
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Group> getGroups(@PathParam("id") String id) {
    	
    }
    */
}
