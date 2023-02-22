package org.example;

import java.util.Scanner;
public class PersonalLoan {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Integer amount,tenure;
        Double emi,totalamount,torepay,interest;
        Double rate;
        System.out.println("Enter Amount");
        amount=sc.nextInt();

        System.out.println("Enter rate");
        rate=sc.nextDouble();
        rate=rate/(12*100);

        System.out.println("Enter tenure");
        tenure=sc.nextInt();
        tenure=tenure*12;

        emi=(amount*rate*Math.pow(1+rate,tenure))/(Math.pow(1+rate,tenure)-1);
        System.out.println("emi is "+emi);

        totalamount=(emi*tenure);
        System.out.println("total amount is "+totalamount);
        System.out.println("To Repay is"+(amount+totalamount));




    }
}

