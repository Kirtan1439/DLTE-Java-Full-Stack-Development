package org.example;

import java.util.Hashtable;

public class TransactionCollection {
    public static void main(String[] args) {
        Hashtable<Integer,String> trans=new Hashtable<>();
        Transaction t1=new Transaction(001,"UPI","credit",);
    }
}

class Transaction{

     private   Integer id;
     private String mode;
     private String type;
     private Double amount;
     private String date;

    public Transaction(Integer id, String s, String upi) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
