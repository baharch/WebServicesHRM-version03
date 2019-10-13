package bahar.model.service;

import bahar.model.entity.Employees;
import bahar.model.repository.EmployeesDAO;

public class EmployeesService {

    private static EmployeesService employeesService = new EmployeesService();
    public static EmployeesService getInstance() {
        return employeesService;
    }

    private EmployeesService() {
    }

    public void save(Employees employee) throws Exception {
        try (EmployeesDAO employeesDAO = new EmployeesDAO()) {
            employeesDAO.insert(employee);
        }
    }

    public void edit(Employees employee) throws Exception {
        try  (EmployeesDAO employeesDAO = new EmployeesDAO()){
            employeesDAO.update(employee);
        }
    }

    public void removeAll() throws Exception {
        try  (EmployeesDAO employeesDAO = new EmployeesDAO()){
            employeesDAO.delete();
        }
    }
    public void removeByID(long employeeID) throws Exception {
        try  (EmployeesDAO employeesDAO = new EmployeesDAO()){
            employeesDAO.deleteByID(employeeID);
        }
    }


    public String findAll() throws Exception {
        try  (EmployeesDAO employeesDAO = new EmployeesDAO()){
            return employeesDAO.select();
        }
    }

    public String findByID(long employeeID) throws Exception {
        try  (EmployeesDAO employeesDAO = new EmployeesDAO()){
            return employeesDAO.selectByID(employeeID);
        }
    }

    public String findByName(String name) throws Exception {
        try  (EmployeesDAO employeesDAO = new EmployeesDAO()){
           return employeesDAO.selectByName(name);
        }
    }

    public String findByFamily(String family) throws Exception {
        try  (EmployeesDAO employeesDAO = new EmployeesDAO()){
           return employeesDAO.selectByFamily(family);
        }
    }

    public String findByNationalCode(long nationalCode) throws Exception {
        try  (EmployeesDAO employeesDAO = new EmployeesDAO()){
           return employeesDAO.selectByNationalCode(nationalCode);
        }
    }


}
