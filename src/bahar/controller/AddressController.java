package bahar.controller;

import bahar.controller.exception.ExceptionWrapper;
import bahar.model.entity.Addresses;
import bahar.model.service.AddressesService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Path("/address")
public class AddressController {
        @GET
        @Produces("text/plain")
        @Path("/save")
        public String save(@Context HttpServletRequest request)
        {
            try {
                Addresses address = new Addresses();
                setAddressFieldes(address, request);
                AddressesService.getInstance().save(address);
                return AddressesService.getInstance().findAll();
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
            Addresses address = new Addresses();
            setAddressFieldes(address, request);
            AddressesService.getInstance().edit(address);
            return AddressesService.getInstance().findAll();
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
            Addresses address = new Addresses();
            address.setAddressID(Long.parseLong(request.getParameter("addressID")));
            AddressesService.getInstance().remove(address.getAddressID());
            return AddressesService.getInstance().findAll();
        }catch (Exception e)
        {
            return ExceptionWrapper.getMessage(e);
        }
    }
    @GET
    @Produces("text/plain")
    @Path("/removeAll")
    public String removeAll(@Context HttpServletRequest request)
    {
        try {
            Addresses address = new Addresses();
            address.setEmployeeID(Long.parseLong(request.getParameter("employeeID")));
            AddressesService.getInstance().removeByEmployeeID(address.getEmployeeID());
            return AddressesService.getInstance().findAll();
        }catch (Exception e)
        {
            return ExceptionWrapper.getMessage(e);
        }
    }


   /* @GET
    @Produces("text/plain")
    @Path("/findAll")
    public String findAll(@Context HttpServletRequest request)
    {
        try {
            return AddressesService.getInstance().findAll();
        }catch (Exception e)
        {
            return ExceptionWrapper.getMessage(e);
        }
    }*/

    @GET
    @Produces("text/plain")
    @Path("/findAll")
    public String findAll(@Context HttpServletRequest request)
    {
        try {
            Addresses address = new Addresses();
            address.setEmployeeID(Long.parseLong(request.getParameter("employeeID")));
            return AddressesService.getInstance().findByEmployeeID(address.getEmployeeID());
        }catch (Exception e)
        {
            return ExceptionWrapper.getMessage(e);
        }
    }
    private void setAddressFieldes(Addresses address,@Context HttpServletRequest request)
    {
        address.setEmployeeID(Long.parseLong(request.getParameter("employeeID")));
        address.setAddressID(Long.parseLong(request.getParameter("addressID")));
        address.setCity(request.getParameter("city"));
        address.setStreet(request.getParameter("street"));
        address.setHouseNo(Integer.parseInt(request.getParameter("houseNo")));
        address.setPostalCode(Integer.parseInt(request.getParameter("postalCode")));

    }
    }

