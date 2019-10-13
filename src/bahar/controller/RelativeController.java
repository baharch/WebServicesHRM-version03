package bahar.controller;

import bahar.controller.exception.ExceptionWrapper;
import bahar.model.entity.Relatives;
import bahar.model.service.RelativesService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Path("/relative")
public class RelativeController {
        @GET
        @Produces("text/plain")
        @Path("/save")
        public String save(@Context HttpServletRequest request)
        {
            try {
                Relatives relative = new Relatives();
                setRelativeFields(relative, request);
                RelativesService.getInstance().save(relative);
                return RelativesService.getInstance().findAll();
            }catch (Exception e)
            {
                return ExceptionWrapper.getMessage(e);
            }
        }

    @GET
    @Produces("text/plain")
    @Path("/edit")
    public String edit(@Context HttpServletRequest request)
    {
        try {
            Relatives relative = new Relatives();
            setRelativeFields(relative, request);
            RelativesService.getInstance().edit(relative);
            return RelativesService.getInstance().findAll();
        }catch (Exception e)
        {
            return ExceptionWrapper.getMessage(e);
        }
    }

    @GET
    @Produces("text/plain")
    @Path("/remove")
    public String remove(@Context HttpServletRequest request)
    {
        try {
            Relatives relative = new Relatives();
            relative.setRelativeID(Long.parseLong(request.getParameter("relativeID")));
            RelativesService.getInstance().remove(relative.getRelativeID());
            return RelativesService.getInstance().findAll();
        }catch (Exception e)
        {
            return ExceptionWrapper.getMessage(e);
        }
    }
    @GET
    @Produces("text/plain")
    @Path("/removeByEmployeeID")
    public String removeByEmployeeID(@Context HttpServletRequest request)
    {
        try {
            Relatives relative = new Relatives();
            relative.setEmployeeID(Long.parseLong(request.getParameter("employeeID")));
            RelativesService.getInstance().removeByEmployeeID(relative.getEmployeeID());
            return RelativesService.getInstance().findAll();
        }catch (Exception e)
        {
            return ExceptionWrapper.getMessage(e);
        }
    }


    @GET
    @Produces("text/plain")
    @Path("/findAll")
    public String findAll(@Context HttpServletRequest request)
    {
        try {
            return RelativesService.getInstance().findAll();
        }catch (Exception e)
        {
            return ExceptionWrapper.getMessage(e);
        }
    }

    @GET
    @Produces("text/plain")
    @Path("/findByEmployeeID")
    public String findByEmployeeID(@Context HttpServletRequest request)
    {
        try {
            Relatives relative = new Relatives();
            relative.setEmployeeID(Long.parseLong(request.getParameter("employeeID")));
            return RelativesService.getInstance().findByEmployeeID(relative.getEmployeeID());
        }catch (Exception e)
        {
            return ExceptionWrapper.getMessage(e);
        }
    }
    private void setRelativeFields(Relatives relative,@Context HttpServletRequest request)
    {
        relative.setEmployeeID(Long.parseLong(request.getParameter("employeeID")));
        relative.setRelativeID(Long.parseLong(request.getParameter("relativeID")));
        relative.setName(request.getParameter("name"));
        relative.setFamily(request.getParameter("family"));
        relative.setRelation(request.getParameter("relation"));

    }
    }

