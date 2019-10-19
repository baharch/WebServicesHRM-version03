package bahar.model.repository;

import bahar.model.common.JDBC;
import bahar.model.entity.Employees;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeesDAO implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public EmployeesDAO() throws Exception {
        connection = JDBC.getConnection();
    }

    @Override
    public void close() throws Exception
    {
        connection.commit();
        preparedStatement.close();
        connection.close();

    }

    public void insert(Employees employee)throws Exception
    {
        preparedStatement = connection.prepareStatement("INSERT INTO employee (employeeID,name,family,email,nationalCode) VALUES (seq_employee.nextval,?,?,?,?)");
        //preparedStatement.setLong(1,);
        preparedStatement.setString(1,employee.getName());
        preparedStatement.setString(2,employee.getFamily());
        preparedStatement.setString(3,employee.getEmail());
        preparedStatement.setLong(4,employee.getNationalCode());
        preparedStatement.executeUpdate();
    }

    public void deleteAll()throws Exception
    {   preparedStatement = connection.prepareStatement("DELETE FROM employee ");
        preparedStatement.executeUpdate();
        preparedStatement = connection.prepareStatement("DELETE FROM address");
        preparedStatement.executeUpdate();
        preparedStatement = connection.prepareStatement("DELETE FROM education");
        preparedStatement.executeUpdate();
        preparedStatement = connection.prepareStatement("DELETE FROM experience");
        preparedStatement.executeUpdate();
        preparedStatement = connection.prepareStatement("DELETE FROM relative ");
        preparedStatement.executeUpdate();
    }

    public void deleteEmployee(long employeeID)throws Exception
    {
        preparedStatement = connection.prepareStatement("DELETE FROM employee WHERE employeeID=?");
        preparedStatement.setLong(1,employeeID);
        preparedStatement.executeUpdate();
        preparedStatement = connection.prepareStatement("DELETE FROM address WHERE employeeID=?");
        preparedStatement.setLong(1,employeeID);
        preparedStatement.executeUpdate();
        preparedStatement = connection.prepareStatement("DELETE FROM education WHERE employeeID=?");
        preparedStatement.setLong(1,employeeID);
        preparedStatement.executeUpdate();
        preparedStatement = connection.prepareStatement("DELETE FROM experience WHERE employeeID=?");
        preparedStatement.setLong(1,employeeID);
        preparedStatement.executeUpdate();
        preparedStatement = connection.prepareStatement("DELETE FROM relative WHERE employeeID=?");
        preparedStatement.setLong(1,employeeID);
        preparedStatement.executeUpdate();
    }

    public void update(Employees employee)throws Exception
    {
        preparedStatement = connection.prepareStatement("UPDATE employee SET name=?,family=?,email=?,nationalCode=? WHERE employeeID=?");
        preparedStatement.setString(1,employee.getName());
        preparedStatement.setString(2,employee.getFamily());
        preparedStatement.setString(3,employee.getEmail());
        preparedStatement.setLong(4,employee.getNationalCode());
        preparedStatement.setLong(5,employee.getEmployeeID());
        preparedStatement.executeUpdate();
    }

    public String select()throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM employee");
        ResultSet resultSet = preparedStatement.executeQuery();

        JSONArray jsonArray=new JSONArray();
        while(resultSet.next())
        {
            jsonArray.add(setJSONObject(resultSet));
        }
        return jsonArray.toJSONString();
    }

    public String selectByID(long employeeID)throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE employeeID=?");
        preparedStatement.setLong(1,employeeID);
        ResultSet resultSet = preparedStatement.executeQuery();

        JSONArray jsonArray=new JSONArray();
        while(resultSet.next())
        {
            jsonArray.add(setJSONObject(resultSet));
        }
        return jsonArray.toJSONString();
    }



        private JSONObject setJSONObject(ResultSet resultSet) throws Exception {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("employeeID",resultSet.getString("employeeID"));
        jsonObject.put("name",resultSet.getString("name"));
        jsonObject.put("family",resultSet.getString("family"));
        jsonObject.put("email",resultSet.getString("email"));
        jsonObject.put("nationalCode",resultSet.getString("nationalCode"));
        return jsonObject;
    }
}
