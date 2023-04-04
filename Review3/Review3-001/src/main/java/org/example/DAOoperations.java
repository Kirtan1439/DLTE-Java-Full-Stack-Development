package org.example;
import oracle.jdbc.driver.OracleDriver;

import java.sql.*;
import java.util.logging.Handler;

public class DAOoperations {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public DAOoperations() {
        try {
            Driver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Acharya1439");
            preparedStatement = connection.prepareStatement("alter session set current_schema=\"KIRTAN U ACHARYA\"");
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Student insertDB(Student student) {
        try {

            preparedStatement = connection.prepareStatement("insert into students1 values(?,?,?,?)");
            preparedStatement.setInt(1, student.getReg_no());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.executeUpdate();

            for (Address address : student.getAddresses()) {
                preparedStatement = connection.prepareStatement("insert into address1 values(address_seq.NEXTVAL,?,?,?,?)");
                preparedStatement.setString(1, address.getStreet());
                preparedStatement.setString(2, address.getCity());
                preparedStatement.setInt(3, address.getPincode());
                preparedStatement.setString(4, address.getType());
                preparedStatement.executeUpdate();
                preparedStatement = connection.prepareStatement("insert into address_mapper values(?,address_seq.CURRVAL)");
                preparedStatement.setInt(1, student.getReg_no());
                preparedStatement.executeUpdate();
            }
            return student;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      return null;
    }



}
