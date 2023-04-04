package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Operations implements StudentEvents {

    Scanner scanner = new Scanner(System.in);
    Connection con;
    PreparedStatement preparedStatement;

    Operations() throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        String oracleUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        con = DriverManager.getConnection(oracleUrl, "system", "Acharya1439");
        preparedStatement = con.prepareStatement("alter session set current_schema=\"KIRTAN U ACHARYA\"");
        preparedStatement.executeQuery();
        System.out.println("Connected");
    }

    @Override
    public void insertData() throws SQLException {
        Student s = new Student();
        System.out.println("Enter the Register No.:");
        s.setReg_no(scanner.nextInt());
        System.out.println("Enter the Name:");
        scanner.nextLine();
        s.setName(scanner.nextLine());
        System.out.println("Enter the Age:");
        s.setAge(scanner.nextInt());
        System.out.println("Enter the Email ID:");
        scanner.nextLine();
        s.setEmail(scanner.nextLine());
        System.out.println("Enter the Locality:");
        s.setLocality(scanner.nextLine());
        System.out.println("Enter the Street:");
        s.setStreet(scanner.nextLine());
        System.out.println("Enter the State:");
        s.setState(scanner.nextLine());
        System.out.println("Enter the Pincode:");
        s.setPincode(scanner.nextInt());
        scanner.nextLine();
        insertDB(s);
    }

    @Override
    public void insertDB(Student student) throws SQLException {

        preparedStatement = con.prepareStatement("insert into addresses values(address_seq.NEXTVAL,?,?,?,?)");
        preparedStatement.setString(1, student.getLocality());
        preparedStatement.setString(2, student.getStreet());
        preparedStatement.setString(3, student.getState());
        preparedStatement.setInt(4, student.getPincode());
        int y = preparedStatement.executeUpdate();
        preparedStatement = con.prepareStatement("insert into studentdetail values(?,?,?,address_seq.CURRVAl,?)");
        preparedStatement.setInt(1, student.getReg_no());
        preparedStatement.setInt(2, student.getAge());
        preparedStatement.setString(3, student.getEmail());
        preparedStatement.setString(4, student.getName());
        int x = preparedStatement.executeUpdate();
        if (x > 0 && y > 0) {
            System.out.println("Insertion successful");
        }
        else {
            System.out.println("Insertion declined");
        }
    }




    @Override
    public void displayData() throws SQLException {
        preparedStatement = con.prepareStatement("select * from studentdetail,addresses where studentdetail.address_id=addresses.address_id");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            System.out.println(rs.getInt("student_reg_no")+" "+rs.getString("student_name")+" "+rs.getInt("student_age")+" "+rs.getString("student_email")+" "+rs.getString("locality")+" "+rs.getString("street")+" "+rs.getString("state")+" "+rs.getInt("pincode"));
        }
    }
}