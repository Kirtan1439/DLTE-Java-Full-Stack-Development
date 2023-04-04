package Handlers;

import lombok.Data;


import java.util.ArrayList;
@Data
public class Student {
    private int reg_no;
    private String name;
    private int age;
    private String email;
    private ArrayList<Address> addresses = new ArrayList<Address>();

    public Student(int reg_no,String name,int age,String email) {
        this.reg_no=reg_no;
        this.name=name;
        this.age=age;
        this.email=email;
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

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(ArrayList<Address> addresses) {
        this.addresses = addresses;
    }

    public Student() {
    }
}
