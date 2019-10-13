package bahar.model.repository;

import bahar.model.common.JDBC;
import bahar.model.entity.Relatives;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RelativesDAO implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public RelativesDAO() throws Exception {
        connection = JDBC.getConnection();
    }
    @Override
    public void close() throws Exception {
        connection.commit();
        preparedStatement.close();
        connection.close();

    }

    public void insert(Relatives relative)throws Exception
{
    preparedStatement = connection.prepareStatement("INSERT INTO relative (employeeID,relativeSEQ.nextval,name,family,relation) VALUES ( ?,?,?,?,?)");
    preparedStatement.setLong(1,relative.getEmployeeID());
    preparedStatement.setLong(2,relative.getRelativeID());
    preparedStatement.setString(3,relative.getName());
    preparedStatement.setString(4,relative.getFamily());
    preparedStatement.setString(5,relative.getRelation());
    preparedStatement.executeUpdate();

}
    public void update(Relatives relative)throws Exception
    {
        preparedStatement = connection.prepareStatement("UPDATE relative SET employeeID=?,name=?,family=?,relation=?) WHERE relativeID=?)");
        preparedStatement.setLong(1,relative.getEmployeeID());
        preparedStatement.setString(2,relative.getName());
        preparedStatement.setString(3,relative.getFamily());
        preparedStatement.setString(4,relative.getRelation());
        preparedStatement.setLong(5,relative.getRelativeID());
        preparedStatement.executeUpdate();
    }

    public void delete(long relativeID )throws Exception
    {
        preparedStatement = connection.prepareStatement("DELETE FROM relative WHERE relativeID=?");
        preparedStatement.setLong(1,relativeID);
        preparedStatement.executeUpdate();
    }

    public void deleteByEmployeeID(long employeeID )throws Exception
    {
        preparedStatement = connection.prepareStatement("DELETE FROM relative WHERE employeeID=?");
        preparedStatement.setLong(1,employeeID);
        preparedStatement.executeUpdate();
    }
    public String select()throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM relative ORDER BY employeeID");
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
        preparedStatement = connection.prepareStatement("SELECT * FROM relative WHERE employeeID=? ");
        preparedStatement.setLong(1,employeeID);
        ResultSet resultSet = preparedStatement.executeQuery();
        JSONArray jsonArray=new JSONArray();
        while(resultSet.next())
        {
            jsonArray.add(setJSONObject(resultSet));
        }
        return jsonArray.toJSONString();
    }
    public String selectByRelativeID(long relativeID)throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT relative.employeeID,employee.name,employee.family FROM relative,employee WHERE relative.relativeID=? ");
        preparedStatement.setLong(1,relativeID);

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
        jsonObject.put("relation",resultSet.getString("relation"));
        return jsonObject;
    }

}
