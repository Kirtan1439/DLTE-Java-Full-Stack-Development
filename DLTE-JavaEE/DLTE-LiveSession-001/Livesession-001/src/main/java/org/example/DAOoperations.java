package org.example;

import oracle.jdbc.driver.OracleDriver;

import java.sql.*;
import java.util.ArrayList;
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

    public void insertDB(Admin admin) {

        try {
            preparedStatement = connection.prepareStatement("insert into admin values(?,?,?,?)");
            preparedStatement.setString(1, admin.getUsername());
            preparedStatement.setString(2, admin.getPassword());
            preparedStatement.setString(3, admin.getFullname());
            preparedStatement.setInt(4, admin.getAge());
            int ex = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Customer> fetch() {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select * from customers1");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customer_id = resultSet.getInt("customer_id");
                String customer_name = resultSet.getString("customer_name");
                String email = resultSet.getString("email");
                String pan = resultSet.getString("pan");
                long contact = resultSet.getLong("contact");
                int pin = resultSet.getInt("pin");
                Customer customer = new Customer(customer_id, customer_name, email, pan, contact, pin);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }


    public String authenticate(String username, String password) {
        try {
             preparedStatement = connection.prepareStatement("select * from admin where username=? and password=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("fullname");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return username;
    }
}