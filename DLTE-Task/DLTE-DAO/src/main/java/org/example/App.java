package org.example;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IdNotfoundException, SQLException {

       DAOoperations daOoperations = new DAOoperations();
//        List<Student> list = new ArrayList<>();
//        list = daOoperations.fetchStudent();
//        System.out.println(list);
//        List<Address> list1 = new ArrayList<>();
//        list1 = daOoperations.fetchAddress(103);
//        System.out.println(list1);
       // System.out.println(daOoperations.deleteDb(110));


        Address address1=new Address("322-1","Nitte","Mangalore",34657);
        ArrayList<Address> address=new ArrayList<>();
       Address address2=new Address("344-1","kengeri","Bangalore",571447);
        address.add(address1);
        address.add(address2);
       Student student=new Student(101,"Manvith","Manvith@123",22,address);
        System.out.println(daOoperations.insertDb(student));


    }
}
