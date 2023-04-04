package org.example;

import oracle.jdbc.OracleDriver;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.sql.*;

public class CustomerCRUD {
    private Driver driver;
    private Connection connection;
    private String query;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public CustomerCRUD(){
        try{
        driver=new OracleDriver();
        DriverManager.registerDriver(driver);
        connection=DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","system","Acharya1439");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @WebMethod
    @WebResult(name = "ListOfCustomer")
      public ListOfCustomer fetch(){
        ListOfCustomer listOfCustomer=new ListOfCustomer();
        try {
              query="select * from Customer";
              preparedStatement=connection.prepareStatement(query);
              resultSet=preparedStatement.executeQuery();
              while(resultSet.next()){
                  Customer customer=new Customer();
                  customer.set(resultSet.getInt(customer_id));

              }

          } catch (SQLException e) {
              e.printStackTrace();
          }

      }
}
