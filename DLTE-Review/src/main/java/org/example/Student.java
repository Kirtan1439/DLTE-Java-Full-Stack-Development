package org.example;

import java.io.Serializable;


public class Student implements Serializable {
    private int reg_no;
    private  String name;
    private int age;
    private  String email;
    private String locality;
    private  String street;
    private String state;
    private int pincode;


    public Student(int reg_no, String name, int age, String email, String locality, String street, String state, int pincode) {
        this.reg_no = reg_no;
        this.name = name;
        this.age = age;
        this.email = email;
        this.locality = locality;
        this.street = street;
        this.state = state;
        this.pincode = pincode;
    }

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

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public Student() {
    }
}
