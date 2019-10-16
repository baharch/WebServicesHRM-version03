package bahar.model.repository;

import bahar.model.common.JDBC;
import bahar.model.entity.Jobs;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JobDAO implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public JobDAO() throws Exception {
        connection = JDBC.getConnection();
    }

    @Override
    public void close() throws Exception {
        connection.commit();
        preparedStatement.close();
        connection.close();
    }

    public void insert(Jobs job)throws Exception
    {
        preparedStatement = connection.prepareStatement("INSERT INTO job (seq_job.nextval,title,description) VALUES ( ?,?)");
        preparedStatement.setString(1,job.getTitle());
        preparedStatement.setString(2,job.getDescription());
        preparedStatement.executeUpdate();
    }

    public void Update(Jobs job)throws Exception
    {
        preparedStatement = connection.prepareStatement("UPDATE job SET (title=?,description=?) WHERE jobID=?");
        preparedStatement.setString(1,job.getTitle());
        preparedStatement.setString(2,job.getDescription());
        preparedStatement.executeUpdate();
    }

    public void jobAllocate(Jobs job)throws Exception
    {
        preparedStatement = connection.prepareStatement("UPDATE job SET (employeeID=?) WHERE jobID=?");
        preparedStatement.setLong(1,job.getEmployeeID());
        preparedStatement.setLong(2,job.getJobID());
        preparedStatement.executeUpdate();
    }

    public void deleteJob(long jobID )throws Exception
    {
        preparedStatement = connection.prepareStatement("DELETE FROM job WHERE jobID=?");
        preparedStatement.setLong(1,jobID);
        preparedStatement.executeUpdate();
    }


    public void deleteAll( )throws Exception
    {
        preparedStatement = connection.prepareStatement("DELETE FROM job ");
        preparedStatement.executeUpdate();
    }

    public String selectAll()throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM job ORDER BY jobID asc ");
        ResultSet resultSet = preparedStatement.executeQuery();

        JSONArray jsonArray=new JSONArray();
        while(resultSet.next())
        {
            jsonArray.add(setJSONObject(resultSet));

        }
        return jsonResult(jsonArray);
    }


    public String selectJobID(long jobID)throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM job WHERE jobID=? ");
        preparedStatement.setLong(1,jobID);
        ResultSet resultSet = preparedStatement.executeQuery();
        JSONArray jsonArray=new JSONArray();
        while(resultSet.next())
        {
            jsonArray.add(setJSONObject(resultSet));
        }
        return jsonResult(jsonArray);
    }

    public String selectJobEmployee(long employeeID)throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM job WHERE employeeID=? ");
        preparedStatement.setLong(1,employeeID);
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
        jsonObject.put("jobID",resultSet.getString("jobID"));
        jsonObject.put("employeeID",resultSet.getLong("employeeID"));
        jsonObject.put("title",resultSet.getString("title"));
        jsonObject.put("description",resultSet.getString("description"));

        return jsonObject;
    }

    private String jsonResult(JSONArray jsonArray){
        JSONObject resultJSON=new JSONObject();
        resultJSON.put("jobs", jsonArray);
        return resultJSON.toJSONString();
    }
}
