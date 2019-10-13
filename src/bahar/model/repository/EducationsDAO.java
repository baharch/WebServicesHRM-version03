package bahar.model.repository;

import bahar.model.common.JDBC;
import bahar.model.entity.Educations;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EducationsDAO  implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public EducationsDAO() throws Exception {
        connection = JDBC.getConnection();
    }
    @Override
    public void close() throws Exception {
        connection.commit();
        preparedStatement.close();
        connection.close();

    }
    public void insert(Educations educations)throws Exception
    {
        preparedStatement = connection.prepareStatement("INSERT INTO education (employeeID,educationID,field,degreeID,university) VALUES ( ?,?,?,?,?)");
        preparedStatement.setLong(1,educations.getEmployeeID());
        preparedStatement.setLong(2,educations.getEducationID());
        preparedStatement.setInt(3,educations.getDegreeID());
        preparedStatement.setString(4,educations.getField());
        preparedStatement.setString(5,educations.getUniversity());
        preparedStatement.executeUpdate();
    }
    public void delete(long educationID )throws Exception
    {
        preparedStatement = connection.prepareStatement("DELETE FROM education WHERE educationID=?");
        preparedStatement.setLong(1,educationID);
        preparedStatement.executeUpdate();
    }
    public void deleteByEmployeeID(long employeeID )throws Exception
    {
        preparedStatement = connection.prepareStatement("DELETE FROM education WHERE employeeID=?");
        preparedStatement.setLong(1,employeeID);
        preparedStatement.executeUpdate();
    }
    public void update(Educations educations)throws Exception
    {
        preparedStatement = connection.prepareStatement("UPDATE education SET employeeID=?,educationID=?,degreeID=?,feild=?,university=?) WHERE educationID=?)");
        preparedStatement.setLong(1,educations.getEmployeeID());
        preparedStatement.setLong(2,educations.getEducationID());
        preparedStatement.setInt(3,educations.getDegreeID());
        preparedStatement.setString(4,educations.getField());
        preparedStatement.setString(5,educations.getUniversity());
        preparedStatement.setLong(6,educations.getEducationID());
        preparedStatement.executeUpdate();
    }
    public String select()throws Exception
    {
        preparedStatement = connection.prepareStatement("select education.*,degree.degree from educations inner join degreeon education.degreeID=degree.degreeID ORDER BY employeeID");
        ResultSet resultSet = preparedStatement.executeQuery();

        JSONArray jsonArray=new JSONArray();
        while(resultSet.next())
        {
            jsonArray.add(setJSONObject(resultSet));

        }
        return jsonArray.toJSONString();
    }

    public String selectByEmployeeID(long employeeID)throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT education.*,degree.degree FROM education INNER JOIN degree on education.degreeID=degree.degreeID WHERE employeeID=?");
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
        jsonObject.put("educationID",resultSet.getString("educationID"));
        jsonObject.put("degree",resultSet.getString("degree"));
        jsonObject.put("field",resultSet.getString("field"));
        jsonObject.put("university",resultSet.getString("university"));
        return jsonObject;
    }
}
