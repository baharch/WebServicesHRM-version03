package bahar.controller;

import bahar.controller.exception.ExceptionWrapper;
import bahar.model.entity.Employees;
import bahar.model.service.EmployeesService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Path("/employee")
public class EmployeeController {
        @GET
        @Produces("text/plain")
        @Path("/save")
        public String save(@Context HttpServletRequest request)
        {
            try {
                Employees employee = new Employees();
                setEmployeefieldes(employee, request);
                EmployeesService.getInstance().save(employee);
                return EmployeesService.getInstance().findAll();
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
            Employees employee = new Employees();
            setEmployeefieldes(employee, request);
            EmployeesService.getInstance().edit(employee);
            return EmployeesService.getInstance().findAll();
        }catch (Exception e)
        {
            return ExceptionWrapper.getMessage(e);
        }
    }

    @GET
    @Produces("text/plain")
    @Path("/removeEmployee")
    public String removeEmployee(@Context HttpServletRequest request)
    {
        try {
            Employees employee = new Employees();
            employee.setEmployeeID(Long.parseLong(request.getParameter("employeeID")));
            EmployeesService.getInstance().removeByID(employee.getEmployeeID());
            return EmployeesService.getInstance().findAll();
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
            Employees employee = new Employees();
            return EmployeesService.getInstance().findAll();
        }catch (Exception e)
        {
            return ExceptionWrapper.getMessage(e);
        }
    }

    @GET
    @Produces("text/plain")
    @Path("/findByID")
    public String findByID(@Context HttpServletRequest request)
    {
        try {
            Employees employee = new Employees();
            employee.setEmployeeID(Long.parseLong(request.getParameter("employeeID")));
            return EmployeesService.getInstance().findByID(employee.getEmployeeID());
        }catch (Exception e)
        {
            return ExceptionWrapper.getMessage(e);
        }
    }

    @GET
    @Produces("text/plain")
    @Path("/findByNameFamily")
    public String findByNameFamily(@Context HttpServletRequest request)
    {
        try {
            Employees employee = new Employees();
            employee.setName(request.getParameter("name"));
            employee.setFamily(request.getParameter("family"));
            return EmployeesService.getInstance().findByNameFamily(employee.getName(),employee.getFamily());
        }catch (Exception e)
        {
            return ExceptionWrapper.getMessage(e);
        }
    }

    private void setEmployeefieldes(Employees employee,@Context HttpServletRequest request)
    {
        employee.setEmployeeID(Long.parseLong(request.getParameter("employeeID")));
        employee.setName(request.getParameter("name"));
        employee.setFamily(request.getParameter("family"));
        employee.setEmail(request.getParameter("email"));
        employee.setNationalCode(Integer.parseInt(request.getParameter("nationalCode")));

    }
    }

