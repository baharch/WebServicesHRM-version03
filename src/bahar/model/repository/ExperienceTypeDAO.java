package bahar.model.repository;

import bahar.model.common.JDBC;
import bahar.model.entity.ExperienceType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ExperienceTypeDAO implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public ExperienceTypeDAO() throws Exception {
        connection = JDBC.getConnection();
    }
    @Override
    public void close() throws Exception {
        connection.commit();
        preparedStatement.close();
        connection.close();

    }
    public void insert(ExperienceType experienceType)throws Exception
    {   preparedStatement = connection.prepareStatement("INSERT INTO experienceType (extTypeID,exType) VALUES (?,?)");
        preparedStatement.setInt(1,experienceType.getExTypeID());
        preparedStatement.setString(2,experienceType.getExType());
        preparedStatement.executeUpdate();
    }
    public void delete(int exTypeID)throws Exception
    {
        preparedStatement = connection.prepareStatement("DELETE FROM experienceType WHERE exTypeID=?");
        preparedStatement.setInt(1,exTypeID);
        preparedStatement.executeUpdate();
    }
    public void update(ExperienceType experienceType)throws Exception
    {
        preparedStatement = connection.prepareStatement("UPDATE experienceType SET exTypeID=?,exType=? WHERE exTypeID=?)");
        preparedStatement.setInt(1,experienceType.getExTypeID());
        preparedStatement.setString(2,experienceType.getExType());
        preparedStatement.setInt(3,experienceType.getExTypeID());
        preparedStatement.executeUpdate();
    }
    public String select()throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM experienceType");
        ResultSet resultSet = preparedStatement.executeQuery();
        JSONArray jsonArray=new JSONArray();
        while(resultSet.next())
        {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("typeID",resultSet.getString("typeID"));
            jsonObject.put("type",resultSet.getString("type"));
            jsonArray.add(jsonObject);
        }
        return jsonArray.toJSONString();
    }


}
