package com.example.rest;

import io.swagger.annotations.Api;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@Api(value="hello")
public class HelloWorldEndpoint {

  @GET
  @Produces("text/plain")
  public Response doGet() {
    nada();
    return Response.ok("Hello from WildFly Swarm! :D agora sim! Como hot swap").build();
  }

  @GET
  @Path("/{id: \\d+}")
  public Response byId(@PathParam("id") Long id){
    return Response.ok("Hello with id "+id).build();
  }

  public void nada(){
    System.out.println("nada");
  }
}