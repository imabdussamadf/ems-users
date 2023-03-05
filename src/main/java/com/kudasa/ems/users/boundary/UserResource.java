/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kudasa.ems.users.boundary;

import com.kudasa.ems.security.boundary.TokenIssuer;
import com.kudasa.ems.users.control.UserService;
import com.kudasa.ems.users.entity.Credential;
import com.kudasa.ems.users.entity.User;
import java.net.URI;
import java.util.Optional;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author abdussamad
 */
@Path("users")
public class UserResource {


    @Inject
    private UserService service;
    
    @Inject
    private TokenIssuer issuer;
    
    public Response getAllUsers() {
        return Response.ok(service.getUsers()).build();
    }

    @GET
    @Path("{id}")
            public Response getUser(@PathParam("id") Long id) {
        System.out.println("request for " + id);
        final Optional<User> userFound = service.getUser(id);
        if (userFound.isPresent()) {
            return Response.ok(userFound.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response add(User newUser, @Context UriInfo uriInfo) {
        service.createUser(newUser);
        return Response.created(getLocation(uriInfo, newUser.getId())).build();
    }
    public Response authenticate(Credential creds) {
        boolean valid = service.isValid(creds.getUsername(), creds.getPassword());
        
        if (valid) {
            String token = issuer.issueToken(creds.getUsername());
            return Response.ok(token).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @PUT
    @Path("{id}")
     public Response update(
            @PathParam("id") Long id, User updated) {
        updated.setId(id);
        boolean done = service.updateUser(updated);

        return done
                ? Response.ok(updated).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Long id) {
        service.removeUser(id);
        return Response.ok().build();
    }

    URI getLocation(UriInfo uriInfo, Long id) {
        return uriInfo.getAbsolutePathBuilder().path("" + id).build();
    }
	
}
