package org.example;
import lombok.Data;

import java.util.Scanner;
@Data


public class Inheritance {
    public static void main(String[] args) {

    }

}
class Kyc{
    private long accno;
    private String name;
    private double balance;
    private Integer upi;
}
class Transaction extends Kyc{
    Scanner scanner= new Scanner(System.in);
     public void balanceEnqiry(){
         System.out.println("Enter the account number,account Holder name :");
         String name= scanner.nextLine();
         long accno = scanner.nextLong();
         


     }
}