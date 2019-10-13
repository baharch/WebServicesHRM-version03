package bahar.model.service;

import bahar.model.entity.Addresses;
import bahar.model.repository.AddressesDAO;

public class AddressesService {
    private static AddressesService ourInstance = new AddressesService();
    public static AddressesService getInstance() {
        return ourInstance;
    }

    private AddressesService() {
    }

    public void save(Addresses address) throws Exception {
        try (AddressesDAO addressesDAO = new AddressesDAO()) {
            addressesDAO.insert(address);
        }
    }

    public void edit(Addresses address) throws Exception {
        try (AddressesDAO addressesDAO = new AddressesDAO()) {
            addressesDAO.update(address);
        }
    }
    public void remove(long addressID) throws Exception {
        try (AddressesDAO addressesDAO = new AddressesDAO()) {
            addressesDAO.delete(addressID);
        }
    }

    public void removeByEmployeeID(long employeeID) throws Exception {
        try (AddressesDAO addressesDAO = new AddressesDAO()) {
            addressesDAO.deleteByEmployeeID(employeeID);
        }
    }

    public String findAll() throws Exception {
        try (AddressesDAO addressesDAO = new AddressesDAO()) {
           return addressesDAO.select();
        }
    }

    public String findByEmployeeID(long employeeID) throws Exception {
        try (AddressesDAO addressesDAO = new AddressesDAO()) {
           return addressesDAO.selectByEmployeeID(employeeID);
        }
    }
}
