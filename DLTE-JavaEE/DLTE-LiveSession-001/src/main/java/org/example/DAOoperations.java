package org.example;


import oracle.jdbc.driver.OracleDriver;

import java.sql.*;
import java.util.List;
import java.util.Queue;


public class DAOoperations {
    private Driver driver;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Queue query;
    private ResultSet resultSet;

    public DAOoperations() {

        try {
            driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Acharya1439");
            preparedStatement = connection.prepareStatement("alter session set current_schema=\"KIRTAN U ACHARYA\"");
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public String authenticate(String username, String password) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from admin where username=? and password=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("username");
            }else
                return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return username;
    }
}