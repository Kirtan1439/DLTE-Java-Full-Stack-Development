package org.example;

import oracle.jdbc.driver.OracleDriver;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOoperations implements Operations {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("student");
    private Connection connection;
    private PreparedStatement preparedStatement;
    Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    @Override
    public String insertDb(Student student) {
        int x=makeConnection();
        if(x==1){
            try {
                preparedStatement=connection.prepareStatement("select * from student_new where email=? and reg_no=?");
                preparedStatement.setString(1,student.getEmail());
                preparedStatement.setInt(2,student.getReg_no());
                preparedStatement.executeQuery();
                ResultSet resultSet=preparedStatement.executeQuery();
                if(resultSet.next()==true){
                    throw new InsertException("");
                }

                preparedStatement = connection.prepareStatement("insert into Student_new values(?,?,?,?,serial_seq.NEXTVAL)");
                preparedStatement.setInt(1,student.getReg_no());
                preparedStatement.setString(2, student.getName());
                preparedStatement.setString(3, student.getEmail());
                preparedStatement.setInt(4, student.getAge());
                preparedStatement.executeUpdate();
                for (Address address : student.getAddresses()) {
                    preparedStatement = connection.prepareStatement("insert into Address_new values(?,?,?,?,serial_seq.CURRVAL,address_seq1.NEXTVAL)");
                    preparedStatement.setString(1, address.getDoor());
                    preparedStatement.setString(2, address.getStreet());
                    preparedStatement.setString(3, address.getCity());
                    preparedStatement.setInt(4, address.getPincode());
                    preparedStatement.executeUpdate();


                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            catch(InsertException id){
                return resourceBundle.getString("dbinsert_exception");
            }

        }
        logger.log(Level.INFO,resourceBundle.getString("dbinsert"));
        return "inserted";
    }


    @Override
    public List<Student> fetchStudent() {
        int y=makeConnection();
        List<Student> list = new ArrayList<>();
        if (y==1){
            try {
                preparedStatement=connection.prepareStatement("select * from student_new");
                preparedStatement.executeQuery();
                ResultSet resultset=preparedStatement.executeQuery();
                logger.log(Level.INFO,resourceBundle.getString("dbstudent_fetch"));


                while(resultset.next()){
                    Student student = new Student();
                    student.setReg_no(resultset.getInt("reg_no"));
                    student.setName(resultset.getString("name"));
                    student.setEmail(resultset.getString("email"));
                    student.setAge(resultset.getInt("age"));
//                    logger.info("student_detail fetched sucessfully");
                    list.add(student);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        logger.log(Level.INFO,resourceBundle.getString("dbfetch"));
        return list;
    }

    @Override
    public List<Address> fetchAddress(int reg_no) {
        int z=makeConnection();
        List<Address> list=new ArrayList<>();
        if(z==1){
            try {

                preparedStatement=connection.prepareStatement("select * from address_new join student_new on serial_no=student_id and reg_no=?");
                preparedStatement.setInt(1,reg_no);
                preparedStatement.executeQuery();
                ResultSet resultSet=preparedStatement.executeQuery();
                logger.log(Level.INFO,resourceBundle.getString("dbadd_fetch"));


                while(resultSet.next()){
                    Address address=new Address();
                    address.setAddress_id(resultSet.getInt("address_id"));
                    address.setDoor(resultSet.getString("door"));
                    address.setStreet(resultSet.getString("street"));
                    address.setCity(resultSet.getString("city"));
                    address.setPincode(resultSet.getInt("pincode"));
                    address.setStudent_id(resultSet.getInt("student_id"));

                    list.add(address);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        logger.log(Level.INFO,resourceBundle.getString("dbfetch"));
        return list;
    }

    @Override
    public String deleteDb(int reg_no) {
        int z=makeConnection();
        try {
            preparedStatement = connection.prepareStatement("delete from student_new where reg_no=?");
            preparedStatement.setInt(1, reg_no);
            int value = preparedStatement.executeUpdate();
            if (value == 0) {
                throw new IdNotfoundException("Student does not exist");
            }else
            {
                return "Deletion Successful";
            }
        }
        catch (IdNotfoundException id){
            return resourceBundle.getString("dbdelete_exception");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.log(Level.INFO,resourceBundle.getString("dbdelete"));
        return "deleted";
    }

    @Override
    public int makeConnection() {
        try {
            Driver driver=new OracleDriver();
            DriverManager.registerDriver(driver);
            //            Connection connection=DriverManager.getConnection(resourceBundle.getString("db.url"),resourceBundle.getString("db.username"),resourceBundle.getString("db.password"));
            connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Acharya1439");
            preparedStatement = connection.prepareStatement("alter session set current_schema=\"KIRTAN U ACHARYA\"");
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
