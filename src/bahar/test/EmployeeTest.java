package bahar.test;

import bahar.controller.EmployeeController;
import bahar.model.entity.Employees;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;

public class EmployeeTest {

    @Test
    public void insertTest() {
        EmployeeController employeeController=new EmployeeController();
        Employees employee = Mockito.mock(Employees.class);
        Mockito.when(employee.getName()).thenReturn("Sam");
        Mockito.when(employee.getFamily()).thenReturn("sami");
        //Mockito.when(employee.getEmployeeID()).thenReturn(123);
      //employeeController.save(employee);

    }
}
