package com.erp.controller;

import com.erp.bean.LoginInfo;
import com.erp.services.LoginService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

@Path("authenticate")
public class Authenticate {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticateUser(LoginInfo login) throws URISyntaxException
    {

        LoginService loginsvc = new LoginService();
        if(loginsvc.verifyUser(login)){
            return Response.ok().build();
        }else{
            return Response.status(203).build();
        }

    }
}
