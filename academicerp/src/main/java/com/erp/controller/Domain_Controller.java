package com.erp.controller;

import com.erp.services.Domain_Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("domain")
public class Domain_Controller {

        @GET
        @Path("/get")
        @Produces(MediaType.APPLICATION_JSON)
        public Response getDomain()
        {
            Domain_Service d = new Domain_Service();
            List<String> domlist = d.getDomainList();
            return Response.ok().entity(domlist).build();
        }
    }

