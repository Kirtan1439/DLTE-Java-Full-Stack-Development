package org.example;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Student_info {
    private static Object detail;

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        String  Reg_No,Name,email,address;
        boolean flag=true;
      Scanner sc=new Scanner(System.in);

        File file = new  File("data.txt");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

      while(flag){
          System.out.println("Enter your choice");
          System.out.println("1.Add Students Info");
          System.out.println("2.Display");
          System.out.println("3.Exit");
          String input=sc.next();

          if(input.equals("1")){
              System.out.println("Enter Students Reg_no");
              Reg_No = sc.next();
              System.out.println("Enter Students Name");
              Name= sc.next();
              System.out.println("Enter Students age");
              int age = sc.nextInt();
              System.out.println("Enter Students Email_Id");
              email= sc.next();
              System.out.println("Enter Students Address,pin code");
              address = sc.next();
              oos.writeObject(new student(Reg_No,Name,email,address,age));
          }
          if(input.equals("2")){

            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois  = new ObjectInputStream(fis);
            System.out.println(ois.readObject());

          }
          if(input.equals("3")){
              return;
          }



      }

    }
}
