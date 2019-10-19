package bahar.model.repository;

import bahar.model.common.JDBC;
import bahar.model.entity.Addresses;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddressesDAO implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public AddressesDAO() throws Exception {
        connection = JDBC.getConnection();
    }
    @Override
    public void close() throws Exception {
        connection.commit();
        preparedStatement.close();
        connection.close();

    }
    public void insert(Addresses address)throws Exception
    {
        preparedStatement = connection.prepareStatement("insert into address (employeeID,addressID,city,street,houseNo,postalCode) values ( ?,seq_address.nextval,? ,?,?,?)");
        preparedStatement.setLong(1,address.getEmployeeID());
        //preparedStatement.setLong(2,address.getAddressID());
        preparedStatement.setString(2,address.getCity());
        preparedStatement.setString(3,address.getStreet());
        preparedStatement.setInt(4,address.getHouseNo());
        preparedStatement.setInt(5,address.getPostalCode());
        preparedStatement.executeUpdate();
    }

    public void update(Addresses address)throws Exception
    {
        preparedStatement = connection.prepareStatement("UPDATE address SET city=?,street=?,houseNo=?,postalCode=?) WHERE addressID=? )");
        preparedStatement.setString(1,address.getCity());
        preparedStatement.setString(2,address.getStreet());
        preparedStatement.setInt(3,address.getHouseNo());
        preparedStatement.setInt(4,address.getPostalCode());
        preparedStatement.setLong(5,address.getAddressID());
        preparedStatement.executeUpdate();
    }
    public void deleteAll()throws Exception
    {
        preparedStatement = connection.prepareStatement("delete from address ");
        preparedStatement.executeUpdate();
    }
    public void deleteAddresses(long employeeID)throws Exception
    {
        preparedStatement = connection.prepareStatement("delete from address where employeeID=?");
        preparedStatement.setLong(1,employeeID);
        preparedStatement.executeUpdate();
    }
    public void deleteAddress(long addressID)throws Exception
    {
        preparedStatement = connection.prepareStatement("delete from address where addressID=?");
        preparedStatement.setLong(1,addressID);
        preparedStatement.executeUpdate();
    }

    public String selectAll()throws Exception
    {
        preparedStatement = connection.prepareStatement("select * from address ORDER BY employeeID,addressID ASC");
        ResultSet resultSet = preparedStatement.executeQuery();

        JSONArray jsonArray=new JSONArray();
        while(resultSet.next())
        {
            jsonArray.add(setJSONObject(resultSet));
        }
        return jsonResult(jsonArray);
    }
    public String selectAddresses(Long employeeID)throws Exception
    {
        preparedStatement = connection.prepareStatement("select * from address where employeeID=? ORDER BY addressID ASC");
        preparedStatement.setLong(1,employeeID);
        ResultSet resultSet = preparedStatement.executeQuery();

        JSONArray jsonArray=new JSONArray();
        while(resultSet.next())
        {
            jsonArray.add(setJSONObject(resultSet));
        }
        return jsonResult(jsonArray);
    }

    public String selectAddress(long addressID)throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM address WHERE addressID=?");
        preparedStatement.setLong(1,addressID);
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
        jsonObject.put("addressID",resultSet.getString("addressID"));
        jsonObject.put("city",resultSet.getString("city"));
        jsonObject.put("street",resultSet.getString("street"));
        jsonObject.put("houseNo",resultSet.getString("houseNo"));
        jsonObject.put("postalCode",resultSet.getString("postalCode"));
        return jsonObject;
    }

    private String jsonResult(JSONArray jsonArray){
        JSONObject resultJSON=new JSONObject();
        resultJSON.put("addresses", jsonArray);
        return resultJSON.toJSONString();
    }

}