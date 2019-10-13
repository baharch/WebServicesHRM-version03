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
    public void close() throws Exception {
        connection.commit();
        preparedStatement.close();
        connection.close();

    }
    public void insert(Employees employee)throws Exception
    {
        preparedStatement = connection.prepareStatement("INSERT INTO employee (employeeID,name,family,email,nationalCode) VALUES (?,?,?,?,?)");
        preparedStatement.setLong(1,employee.getEmployeeID());
        preparedStatement.setString(2,employee.getName());
        preparedStatement.setString(3,employee.getFamily());
        preparedStatement.setString(4,employee.getEmail());
        preparedStatement.setLong(5,employee.getNationalCode());
        preparedStatement.executeUpdate();
    }
    public void delete()throws Exception
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
    public void deleteByID(long employeeID)throws Exception
    {
        preparedStatement = connection.prepareStatement("DELETE FROM employees WHERE employeeID=?");
        preparedStatement.setLong(1,employeeID);
        preparedStatement.executeUpdate();
        preparedStatement = connection.prepareStatement("DELETE FROM addresse WHERE employeeID=?");
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
        preparedStatement = connection.prepareStatement("UPDATE employee SET (name=?,family=?,email=?,nationalCode=?) WHERE employeeID=?)");
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
    public String selectByNationalCode(long nationalCode)throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE nationalCode=?");
        preparedStatement.setLong(1,nationalCode);
        ResultSet resultSet = preparedStatement.executeQuery();

        JSONArray jsonArray=new JSONArray();
        while(resultSet.next())
        {
           jsonArray.add(setJSONObject(resultSet));
        }
        return jsonArray.toJSONString();
    }

    public String selectByName(String employeeName)throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE name=? ");
        preparedStatement.setString(1,employeeName);
        ResultSet resultSet = preparedStatement.executeQuery();

        JSONArray jsonArray=new JSONArray();
        while(resultSet.next())
        {
            jsonArray.add(setJSONObject(resultSet));

        }
        return jsonArray.toJSONString();
    }

    public String selectByFamily(String employeeFamily)throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE family=?");
        preparedStatement.setString(1,employeeFamily);
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
