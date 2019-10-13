package bahar.model.repository;

import bahar.model.common.JDBC;
import bahar.model.entity.Degrees;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DegreesDAO implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public DegreesDAO() throws Exception {
        connection = JDBC.getConnection();
    }
    @Override
    public void close() throws Exception {
        connection.commit();
        preparedStatement.close();
        connection.close();

    }
    public void insert(Degrees degree)throws Exception
    {
        preparedStatement = connection.prepareStatement("INSERT INTO degree (degreeID,degree) VALUES (?,?)");
        preparedStatement.setInt(1,degree.getDegreeID());
        preparedStatement.setString(2,degree.getDegree());
        preparedStatement.executeUpdate();
    }
    public void delete(int degreeID)throws Exception
    {
        preparedStatement = connection.prepareStatement("DELETE FROM degree WHERE gedreeID=?");
        preparedStatement.setInt(1,degreeID);
        preparedStatement.executeUpdate();
    }
    public void update(Degrees degree)throws Exception
    {
        preparedStatement = connection.prepareStatement("UPDATE degree SET (degreeID=?,degree=?) WHERE degree=?)");
        preparedStatement.setInt(1,degree.getDegreeID());
        preparedStatement.setString(2,degree.getDegree());
        preparedStatement.executeUpdate();
    }
    public String select()throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM degree");
        ResultSet resultSet = preparedStatement.executeQuery();
        JSONArray jsonArray=new JSONArray();
        while(resultSet.next())
        {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("degreeID",resultSet.getString("degreeID"));
            jsonObject.put("degree",resultSet.getString("degree"));
            jsonArray.add(jsonObject);
        }
        return jsonArray.toJSONString();
    }

}