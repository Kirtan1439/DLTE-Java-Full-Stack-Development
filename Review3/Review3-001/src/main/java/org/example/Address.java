package org.example;


import lombok.Data;

@Data
public class Address {
    private String door_no;
    private String street;
    private String city;
    private int pincode;
    private  String type;

    public Address(String tytiu, String door_no, String street, int i) {
        this.door_no = door_no;
        this.street = street;
        this.city = city;
        this.pincode = pincode;
        this.type = type;
    }

    public String getDoor_no() {
        return door_no;
    }

    public void setDoor_no(String door_no) {
        this.door_no = door_no;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Address(String dudfg1) {
    }
}

