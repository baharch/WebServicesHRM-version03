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
        preparedStatement = connection.prepareStatement("INSERT INTO experience (employeeID,experienceID,exType, institute,title,exDate) VALUES ( ?,seq_experience,?,?,?,?)");
        preparedStatement.setLong(1,experience.getEmployeeID());
        preparedStatement.setString(2,experience.getExType());
        preparedStatement.setString(3,experience.getInstitute());
        preparedStatement.setString(4,experience.getTitle());
        preparedStatement.setString(5,experience.getExDate());
        preparedStatement.executeUpdate();
    }

    public void update(Experiences experience)throws Exception
    {
        preparedStatement = connection.prepareStatement("UPDATE experience SET exType=?,title=?,institute=?,exDate=? WHERE experienceID=?");
        preparedStatement.setString(1,experience.getExType());
        preparedStatement.setString(2,experience.getTitle());
        preparedStatement.setString(3,experience.getInstitute());
        preparedStatement.setString(4,experience.getExDate());
        preparedStatement.setLong(5,experience.getExperienceID());
        preparedStatement.executeUpdate();
    }
    public void deleteAll( )throws Exception
    {
        preparedStatement = connection.prepareStatement("DELETE FROM experience ");
        preparedStatement.executeUpdate();
    }
    public void deleteExperiences(long employeeID )throws Exception
    {
        preparedStatement = connection.prepareStatement("DELETE FROM experience WHERE employeeID=?");
        preparedStatement.setLong(1,employeeID);
        preparedStatement.executeUpdate();
    }
    public void deleteExperience(long experienceID )throws Exception
    {
        preparedStatement = connection.prepareStatement("DELETE FROM experience WHERE experienceID=?");
        preparedStatement.setLong(1,experienceID);
        preparedStatement.executeUpdate();
    }
    public String selectAll()throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM experience  ORDER BY employeeID");
        ResultSet resultSet = preparedStatement.executeQuery();

        JSONArray jsonArray=new JSONArray();
        while(resultSet.next())
        {
            jsonArray.add(setJSONObject(resultSet));
        }
        return jsonArray.toJSONString();
    }

    public String selectExperiences(long employeeID)throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM experience WHERE employeeID=?");
        preparedStatement.setLong(1,employeeID);
        ResultSet resultSet = preparedStatement.executeQuery();

        JSONArray jsonArray=new JSONArray();
        while(resultSet.next())
        {
            jsonArray.add(setJSONObject(resultSet));
        }
        return jsonArray.toJSONString();
    }

    public String selectExperience(long experienceID)throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM experience  where experienceID=?");
        preparedStatement.setLong(1,experienceID);
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
        jsonObject.put("exType",resultSet.getString("exType"));
        jsonObject.put("title",resultSet.getString("title"));
        jsonObject.put("institute",resultSet.getString("institute"));
        jsonObject.put("exDate",resultSet.getString("exDate"));
        return jsonObject;
    }
}
