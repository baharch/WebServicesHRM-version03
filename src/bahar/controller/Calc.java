package bahar.controller;
import javax.servlet.http.HttpServletRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;

@Path("/calc")
public class Calc {
    @Path("/jam")
    @GET
    @Produces("text/plain")
    public String sum(@QueryParam("p1") String x, @QueryParam("p2") String y) {
        int result = Integer.parseInt(x) + Integer.parseInt(y);
        System.out.println("sum executed...");
        return String.valueOf(result);
    }
    @Path("/minus")
    @GET
    @Produces("text/plain")
    public String minus(@QueryParam("p1") String x, @QueryParam("p2") String y) {
        int result = Integer.parseInt(x) - Integer.parseInt(y);
        System.out.println("minus executed...");
        return String.valueOf(result);
    }
    @GET
    @Produces("text/plain")
    @Path("/sum2")
    public String sum(@Context HttpServletRequest request)
    {
        System.out.println("sum executed...");
        return request.getParameter("x")+request.getParameter("y");
    }
    @Path("/sss")
    @Produces("text/plain")
    @GET
    public String test()
    {
        return "HELLO";
    }
}
