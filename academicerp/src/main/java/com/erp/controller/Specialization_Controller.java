package com.erp.controller;

import com.erp.services.Specialization_Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("specialization")
public class Specialization_Controller {

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpez()
    {
        Specialization_Service s = new Specialization_Service();
        List<String> spezlist = s.getSpecialization();
        return Response.ok().entity(spezlist).build();
    }
}
