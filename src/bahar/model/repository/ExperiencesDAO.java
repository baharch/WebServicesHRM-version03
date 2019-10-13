package bahar.model.repository;

import bahar.model.common.JDBC;
import bahar.model.entity.Experiences;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ExperiencesDAO implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public ExperiencesDAO() throws Exception {
        connection = JDBC.getConnection();
    }
    @Override
    public void close() throws Exception {
        connection.commit();
        preparedStatement.close();
        connection.close();

    }
    public void insert(Experiences experience)throws Exception
    {
        preparedStatement = connection.prepareStatement("INSERT INTO experience (employeeID,experienceID,experienceType, institute,title,exDate) VALUES ( ?,?,?,?,?,?)");
        preparedStatement.setLong(1,experience.getEmployeeID());
        preparedStatement.setLong(2,experience.getExperienceID());
        preparedStatement.setInt(3,experience.getExperienceType());
        preparedStatement.setString(4,experience.getInstitute());
        preparedStatement.setString(5,experience.getTitle());
        preparedStatement.setString(6,experience.getExDate());
        preparedStatement.executeUpdate();
    }

    public void update(Experiences experience)throws Exception
    {
        preparedStatement = connection.prepareStatement("UPDATE experience SET employeeID=?,experienceID=?,experienceType=?,title=?,institute=?,exDate=? WHERE experienceID=?");
        preparedStatement.setLong(1,experience.getEmployeeID());
        preparedStatement.setLong(2,experience.getExperienceID());
        preparedStatement.setInt(3,experience.getExperienceType());
        preparedStatement.setString(4,experience.getTitle());
        preparedStatement.setString(5,experience.getInstitute());
        preparedStatement.setString(6,experience.getExDate());
        preparedStatement.setLong(7,experience.getExperienceID());
        preparedStatement.executeUpdate();
    }
    public void delete(long experienceID )throws Exception
    {
        preparedStatement = connection.prepareStatement("DELETE FROM experience WHERE experienceID=?");
        preparedStatement.setLong(1,experienceID);
        preparedStatement.executeUpdate();
    }

    public void deleteByEmployeeID(long employeeID )throws Exception
    {
        preparedStatement = connection.prepareStatement("DELETE FROM experience WHERE employeeID=?");
        preparedStatement.setLong(1,employeeID);
        preparedStatement.executeUpdate();
    }
    public String select()throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT experience.*,experienceType.exTypeID FROM experience INNER JOIN experienceType experience.experienceID=experienceType.experienceID ORDER BY employeeID");
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
        preparedStatement = connection.prepareStatement("SELECT experience.*,experienceType.experienceID FROM experience INNER JOIN experienceType experience.experienceID=experienceType.experienceID WHERE employeeID=?");
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
        jsonObject.put("experienceID",resultSet.getString("experienceID"));
        jsonObject.put("typeID",resultSet.getString("typeID"));
        jsonObject.put("type",resultSet.getString("type"));
        jsonObject.put("title",resultSet.getString("title"));
        jsonObject.put("institute",resultSet.getString("institute"));
        jsonObject.put("exDate",resultSet.getString("exDate"));
        return jsonObject;
    }
}
