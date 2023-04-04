package org.example;

import java.lang.reflect.Array;
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
      System.out.println(daOoperations.authenticate("Kirtan","Kirtan@123"));
      System.out.println(daOoperations.fetch());
    }
}
