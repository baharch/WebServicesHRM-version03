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
    public void removeAll() throws Exception {
        try (AddressesDAO addressesDAO = new AddressesDAO()) {
            addressesDAO.deleteAll();
        }
    }

    public void removeAddresses(long employeeID) throws Exception {
        try (AddressesDAO addressesDAO = new AddressesDAO()) {
            addressesDAO.deleteAddresses(employeeID);
        }
    }

    public void removeAddress(long addressID) throws Exception {
        try (AddressesDAO addressesDAO = new AddressesDAO()) {
            addressesDAO.deleteAddress(addressID);
        }
    }

    public String findAll() throws Exception {
        try (AddressesDAO addressesDAO = new AddressesDAO()) {
           return addressesDAO.selectAll();
        }
    }

    public String findAddresses(long employeeID) throws Exception {
        try (AddressesDAO addressesDAO = new AddressesDAO()) {
           return addressesDAO.selectAddresses(employeeID);
        }
    }

    public String findAddress(long addressID) throws Exception {
        try (AddressesDAO addressesDAO = new AddressesDAO()) {
            return addressesDAO.selectAddress(addressID);
        }
    }
}
