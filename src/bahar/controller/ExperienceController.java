package bahar.controller;

import bahar.controller.exception.ExceptionWrapper;
import bahar.model.entity.Experiences;
import bahar.model.service.ExperiencesService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Path("/experience")
public class ExperienceController {
        @GET
        @Produces("text/plain")
        @Path("/save")
        public String save(@Context HttpServletRequest request)
        {
            try {
                Experiences experience = new Experiences();
                setExperienceFields(experience, request);
                ExperiencesService.getInstance().save(experience);
                return ExperiencesService.getInstance().findAll();
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
            Experiences experience = new Experiences();
            setExperienceFields(experience, request);
            ExperiencesService.getInstance().edit(experience);
            return ExperiencesService.getInstance().findAll();
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
            Experiences experience = new Experiences();
            experience.setExperienceID(Long.parseLong(request.getParameter("experienceID")));
            ExperiencesService.getInstance().remove(experience.getExperienceID());
            return ExperiencesService.getInstance().findAll();
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
            Experiences experience = new Experiences();
            experience.setEmployeeID(Long.parseLong(request.getParameter("employeeID")));
            ExperiencesService.getInstance().removeByEmployeeID(experience.getEmployeeID());
            return ExperiencesService.getInstance().findAll();
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
            return ExperiencesService.getInstance().findAll();
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
            Experiences experience = new Experiences();
            experience.setEmployeeID(Long.parseLong(request.getParameter("employeeID")));
            return ExperiencesService.getInstance().findByEmployeeID(experience.getEmployeeID());
        }catch (Exception e)
        {
            return ExceptionWrapper.getMessage(e);
        }
    }
    private void setExperienceFields(Experiences experience,@Context HttpServletRequest request)
    {
        experience.setEmployeeID(Long.parseLong(request.getParameter("employeeID")));
        experience.setExperienceID(Long.parseLong(request.getParameter("experienceID")));
        experience.setExperienceType(Integer.parseInt(request.getParameter("experienceType")));
        experience.setTitle(request.getParameter("title"));
        experience.setInstitute(request.getParameter("institute"));
        experience.setExDate(request.getParameter("exDate"));

    }
    }

