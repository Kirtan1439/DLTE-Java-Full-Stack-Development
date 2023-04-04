package org.example;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


public class Student {
    public Student() {
    }

    public Student(int reg_no, String name, int age, String email, ArrayList<Address> addresses) {
        this.reg_no = reg_no;
        this.name = name;
        this.age = age;
        this.email = email;
        this.addresses = addresses;
    }

    private int reg_no;
    private String name;
    private int age;

    public int getReg_no() {
        return reg_no;
    }

    public void setReg_no(int reg_no) {
        this.reg_no = reg_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "reg_no=" + reg_no +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", addresses=" + addresses +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(ArrayList<Address> addresses) {
        this.addresses = addresses;
    }

    private String email;
    private ArrayList<Address> addresses=new ArrayList<>();

//    public Student(int i, String tdyfi, int i1, String s, ArrayList<Address> addresses) {
//    }

//    public Student(int reg_no,String name,int age,String email) {
//        this.reg_no=reg_no;
//        this.name=name;
//        this.age=age;
//        this.email=email;
//    }

//    public int getReg_no() {
//        return reg_no;
//    }
//
//    public void setReg_no(int reg_no) {
//        this.reg_no = reg_no;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public ArrayList<Address> getAddresses() {
//        return addresses;
//    }
//
//    public void setAddresses(ArrayList<Address> addresses) {
//        this.addresses = addresses;
//    }
//
//    public Student() {
//    }
}

