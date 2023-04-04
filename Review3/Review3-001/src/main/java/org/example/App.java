package org.example;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )

    {
         DAOoperations daOoperations=new DAOoperations();
        Address address1=new Address("tytiu","dfyghu","rutiyuo",32456);
        Address address2=new Address("xfjkjh","dfyghu","rutiyuo",76548);
        ArrayList<Address> address = new ArrayList<>();
        address.add(address1);
        address.add(address2);
        Student student=new Student(543,"tdyfi",21,"Kirtan@123",address);
        //Student student=new Student();
        System.out.println(student);
          //System.out.println(daOoperations.insertDB(student));


    }
}
