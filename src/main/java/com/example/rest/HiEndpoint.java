package com.example.rest;

import io.swagger.annotations.Api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by rafael on 5/23/16.
 */
@Path("/hi")
@Produces(MediaType.TEXT_PLAIN)
@Api(value="hi",description = "yet another salutation :D")
public class HiEndpoint {

    @GET
    public Response get(){
        return Response.ok("This is not Hello, its Hi! :D").build();
    }
}
