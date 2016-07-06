package com.example.rest;

import io.swagger.annotations.Api;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("/hello")
@Produces(MediaType.TEXT_PLAIN)
@Api(value="hello",description = "That should say Hello! Isn't that polite? :D")
public class HelloWorldEndpoint {

  @GET
  public Response doGet() {
    nothing();
    return Response.ok("Hello from WildFly Swarm! :D agora sim! Como hot swap!").build();
  }

  @GET
  @Path("/{id: \\d+}")
  public Response byId(@PathParam("id") Long id){
    return Response.ok("Hello with id "+id).build();
  }

  public void nothing(){
    System.out.println("nothing");
  }
}