package com.example.rest;

import com.example.dao.PersonDAO;
import com.example.model.Person;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Random;

/**
 * Created by rafael on 6/27/16.
 */
@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
public class PersonEndpoint {


    @Inject
    PersonDAO dao;

    @GET
    public Response get(){
        return Response.ok(dao.findAll()).build();
    }

    @GET
    @Path("/{id: \\d+}")
    public Response byId(@PathParam("id")Long id) throws Exception {
        Person person = new Person(id, "Person " + id);
        return Response.ok(person).build();
    }

}
