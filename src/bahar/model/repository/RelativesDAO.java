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
    preparedStatement = connection.prepareStatement("INSERT INTO relative (employeeID,seq_employee.nextval,name,family,relation) VALUES ( ?,?,?,?)");
    preparedStatement.setLong(1,relative.getEmployeeID());
   // preparedStatement.setLong(2,relative.getRelativeID());
    preparedStatement.setString(2,relative.getName());
    preparedStatement.setString(3,relative.getFamily());
    preparedStatement.setString(4,relative.getRelation());
    preparedStatement.executeUpdate();
}
    public void update(Relatives relative)throws Exception
    {
        preparedStatement = connection.prepareStatement("UPDATE relative SET (name=?,family=?,relation=?) WHERE relativeID=?");

        preparedStatement.setString(1,relative.getName());
        preparedStatement.setString(2,relative.getFamily());
        preparedStatement.setString(3,relative.getRelation());
        preparedStatement.setLong(4,relative.getRelativeID());
        preparedStatement.executeUpdate();
    }

    //delete one of the employee's relatives from table relative
    public void deleteRelative(long relativeID )throws Exception
    {
        preparedStatement = connection.prepareStatement("DELETE FROM relative WHERE relativeID=?");
        preparedStatement.setLong(1,relativeID);
        preparedStatement.executeUpdate();
    }

    //delete All of the employee's relatives from  relative table
    public void deleteRelatives(long employeeID )throws Exception
    {
        preparedStatement = connection.prepareStatement("DELETE FROM relative WHERE employeeID=?");
        preparedStatement.setLong(1,employeeID);
        preparedStatement.executeUpdate();
    }

    //delete All the records of relative table
    public void deleteAll( )throws Exception
    {
        preparedStatement = connection.prepareStatement("DELETE FROM relative ");
        preparedStatement.executeUpdate();
    }


    //select all the relatives of all employee
    public String selectAll()throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM relative ORDER BY employeeID , relaiveID asc ");
        ResultSet resultSet = preparedStatement.executeQuery();

        JSONArray jsonArray=new JSONArray();
        while(resultSet.next())
        {
            jsonArray.add(setJSONObject(resultSet));

        }
        return jsonResult(jsonArray);
    }

    //select all the relatives of an employee
    public String selectRelatives(long employeeID)throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM relative WHERE employeeID=?  order by relativeID asc ");
        preparedStatement.setLong(1,employeeID);
        ResultSet resultSet = preparedStatement.executeQuery();
        JSONArray jsonArray=new JSONArray();
        while(resultSet.next())
        {
            jsonArray.add(setJSONObject(resultSet));
        }
        return jsonResult(jsonArray);
    }


    //select an certain relative of employee
    public String selectRelative(long relativeID)throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM relative WHERE relativeID=? ");
        preparedStatement.setLong(1,relativeID);

        ResultSet resultSet = preparedStatement.executeQuery();

        JSONArray jsonArray=new JSONArray();
        while(resultSet.next())
        {
            jsonArray.add(setJSONObject(resultSet));


        }
        return jsonResult(jsonArray);
    }

    private JSONObject setJSONObject(ResultSet resultSet) throws Exception {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("employeeID",resultSet.getString("employeeID"));
        jsonObject.put("relativeID",resultSet.getLong("relativeID"));
        jsonObject.put("name",resultSet.getString("name"));
        jsonObject.put("family",resultSet.getString("family"));
        jsonObject.put("relation",resultSet.getString("relation"));
        return jsonObject;
    }

    private String jsonResult(JSONArray jsonArray){
        JSONObject resultJSON=new JSONObject();
        resultJSON.put("relative", jsonArray);
        return resultJSON.toJSONString();
    }

}
