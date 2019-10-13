package bahar.controller;

import bahar.controller.exception.ExceptionWrapper;
import bahar.model.entity.Educations;
import bahar.model.service.EducationsService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Path("/education")
public class EducationController {
        @GET
        @Produces("text/plain")
        @Path("/save")
        public String save(@Context HttpServletRequest request)
        {
            try {
                Educations education = new Educations();
                setEducationFields(education, request);
                EducationsService.getInstance().save(education);
                return EducationsService.getInstance().findAll();
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
            Educations education = new Educations();
            setEducationFields(education, request);
            EducationsService.getInstance().edit(education);
            return EducationsService.getInstance().findAll();
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
            Educations education = new Educations();
            education.setEducationID(Long.parseLong(request.getParameter("educationID")));
            EducationsService.getInstance().remove(education.getEducationID());
            return EducationsService.getInstance().findAll();
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
            Educations education = new Educations();
            education.setEmployeeID(Long.parseLong(request.getParameter("employeeID")));
            EducationsService.getInstance().removeByEmployeeID(education.getEmployeeID());
            return EducationsService.getInstance().findAll();
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
            return EducationsService.getInstance().findAll();
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
            Educations education = new Educations();
            education.setEmployeeID(Long.parseLong(request.getParameter("employeeID")));
            return EducationsService.getInstance().findByEmployeeID(education.getEmployeeID());
        }catch (Exception e)
        {
            return ExceptionWrapper.getMessage(e);
        }
    }
    private void setEducationFields(Educations education,@Context HttpServletRequest request)
    {
        education.setEmployeeID(Long.parseLong(request.getParameter("employeeID")));
        education.setEducationID(Long.parseLong(request.getParameter("educationID")));
        education.setDegreeID(Integer.parseInt(request.getParameter("degreeID")));
        education.setField(request.getParameter("field"));
        education.setUniversity(request.getParameter("university"));

    }
    }

