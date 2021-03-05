package com.erp.controller;


import com.erp.services.CourseService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("courses")
public class CourseController {

    @POST
    @Path("/post")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postCourseDetails(PostCourseRequest request)
    {

        CourseService cservice = new CourseService();
        if(cservice.postCourse(request))
        {
            return Response.status(200).build();

        }
        else
        {
            return Response.status(204).build();
        }

    }
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrerequisites()
    {
        CourseService c = new CourseService();
        List<String> pre = c.getPrerequisites();
        return Response.ok().entity(pre).build();

    }
}
