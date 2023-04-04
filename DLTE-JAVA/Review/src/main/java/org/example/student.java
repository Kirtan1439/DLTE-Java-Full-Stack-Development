package org.example;


import java.io.Serializable;
import java.util.Scanner;

public class student implements Serializable {

    private String Reg_No,Name,Email,Address;
    private int age;

    public student(String reg_No, String name, String email, String address, int age) {
        this.Reg_No = reg_No;
        this.Name = name;
        this.Email = email;
        this.Address = address;
        this.age = age;
    }

    @Override
    public String toString() {
        return "student{" +
                "Reg_No='" + Reg_No + '\'' +
                ", Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", Address='" + Address + '\'' +
                ", age=" + age +
                '}';
    }

    public String getReg_No() {
        return Reg_No;
    }

    public void setReg_No(String reg_No) {
        Reg_No = reg_No;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


