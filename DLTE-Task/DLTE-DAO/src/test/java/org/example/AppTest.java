package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
@ExtendWith(MockitoExtension.class)
public class AppTest {
    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSet;
    @Mock
    private ArrayList<Address> address = new ArrayList<>();
    @Mock
    private Operations operations=new DAOoperations();


//    @Test
//    public void assemble() throws SQLException {
//
//        lenient().when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
//
//        lenient().when(preparedStatement.executeUpdate()).thenReturn(1);
//
//    }
      @BeforeEach
    public void assemble() throws SQLException {

        lenient().when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);

        lenient().when(preparedStatement.executeUpdate()).thenReturn(1);

    }

    //    @Test
//    public void testInsertion(){
//        Student student=new Student();
//        Address address1=new Address("12","street1","city1",435879);
//        Address address2=new Address("22","street2","city2",243567);
//        address.add(address1);address.add(address2);
//        student.setAge(21);student.setEmail("Kirtan@gmail.com");student.setName("Kirtan");student.setReg_no(43456);student.setAddresses(address);
//        operations.insertDb(student);
//
//        when(operations.insertDb(student)).thenReturn("inserted");
//
//        assertEquals("inserted",operations.insertDb(student));
//    }
    @Test
    public void testFetch(){
       Student student=new Student();
        Address address1=new Address("3551-2","street1","city1",4567);
        Address address2=new Address("455-1","street2","city2",45768);
        address.add(address1);
        address.add(address2);
        operations.fetchAddress(101);
        operations.fetchStudent();

//        when(operations.fetchAddress(101)).thenReturn(address);
//
//      when(operations.fetchStudent());

        assertEquals(address,operations.fetchAddress(115));


        }

    @Test
    public void testFetch2(){
       Student student=new Student();
        Address address1=new Address("12","street1","city1",435879);
        Address address2=new Address("22","street2","city2",243567);
        address.add(address1);
        address.add(address2);
        student.setAge(21);student.setEmail("Kirtan@gmail.com");student.setName("Kirtan");student.setReg_no(43456);student.setAddresses(address);
        operations.fetchAddress(345);
        System.out.println(student);


    }


        //}
    }
//    /**
//     * Rigorous Test :-)
//     */
//    @Test
//    public void shouldAnswerWithTrue()
//    {
//        assertTrue( true );
//    }



