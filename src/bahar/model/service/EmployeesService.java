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
//clear All tables
    public void removeAll() throws Exception {
        try  (EmployeesDAO employeesDAO = new EmployeesDAO()){
            employeesDAO.deleteAll();
        }
    }

    //delete all the records in all tables related to the employeeID
    public void removeByID(long employeeID) throws Exception {
        try  (EmployeesDAO employeesDAO = new EmployeesDAO()){
            employeesDAO.deleteEmployee(employeeID);
        }
    }

//list of all the record of employee table
    public String findAll() throws Exception {
        try  (EmployeesDAO employeesDAO = new EmployeesDAO()){
            return employeesDAO.select();
        }
    }

//the information of the employee from employee table find by employeeID
    public String findByID(long employeeID) throws Exception {
        try  (EmployeesDAO employeesDAO = new EmployeesDAO()){
            return employeesDAO.selectByID(employeeID);
        }
    }






}
