package com.gtnow.backend1.webservices;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.gtnow.backend1.OfyService;
import com.gtnow.backend1.objects.User;

/**
 * This web service handles all the different http calls from a client to create, read, update, and delete TodoLists.
 * This is done using Jersey/JAX-RS (Java Application Rest Service API).
 */
@Path("api/users")
public class UserWebService {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
    	
    	Objectify ofy = OfyService.ofy();
    	
        return ofy.load().type(User.class).list();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User saveNewUser(User user) {
    	Objectify ofy = OfyService.ofy();
        Key<User> key = ofy.save().entity(user).now();
        return ofy.load().key(key).now();
    }
}
