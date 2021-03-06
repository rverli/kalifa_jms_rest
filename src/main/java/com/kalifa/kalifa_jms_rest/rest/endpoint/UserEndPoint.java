package com.kalifa.kalifa_jms_rest.rest.endpoint;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kalifa.kalifa_jms_rest.dto.User;
import com.kalifa.kalifa_jms_rest.service.UserService;

@Component
@Path("/users")
public class UserEndPoint {

	@Autowired
	private UserService userService;

    @GET
    @Produces("application/json")
    @Path("/")
    //http://localhost:8080/v1/users/
    public List<User> findAll() {
  	  
  	  List<User> list = new ArrayList<>();
  	  userService.findAll()
  	  			 .forEach( (k,v) -> list.add(v) );
  	  return list;
    }
    
    @GET
    @Path("/{id}")
    @Produces("application/json")
    //http://localhost:8080/v1/users/7
    public User getUser(@PathParam("id") String id) {
      return userService.findById(id);
    }
    
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response addUser(User user) {
    	
    	userService.addUser(user);
        return Response.created(URI.create("/" + user.getId())).build();
    }
    
    @PUT
    @Consumes("application/json")
    @Path("/{id}")
    public Response updateUser(@PathParam("id") String id, User user) {
        
    	userService.updateUser( id, user );
        return Response.noContent().build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") String id) {
        
    	userService.deleteBook( id );
        return Response.ok().build();
    }
}
