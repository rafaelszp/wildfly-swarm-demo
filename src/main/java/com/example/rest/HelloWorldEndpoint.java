package com.example.rest;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("/hello")
public class HelloWorldEndpoint {

  @GET
  @Produces("text/plain")
  public Response doGet() {
    nada();
    return Response.ok("Hello from WildFly Swarm! :D agora sim!").build();
  }

  public void nada(){
    System.out.println("nada");
  }
}