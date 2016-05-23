package com.example.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by rafael on 5/23/16.
 */
@Path("/hi")
public class HiEndpoint {

    @GET
    public Response get(){
        return Response.ok("This is not Hello, its Hi! :D").build();
    }
}
