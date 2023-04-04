package org.example;

import java.util.Scanner;

public class abc {
    public static void main(String[] args) {
        System.out.println("hi");
        Scanner sc = new Scanner(System.in);
        System.out.println("enter age of the person:");
        int childAge = sc.nextInt();
        First obj=new First(childAge);
    }

}
class First{
    int age;
      First(int childAge){
         this.age=childAge;
    }
}