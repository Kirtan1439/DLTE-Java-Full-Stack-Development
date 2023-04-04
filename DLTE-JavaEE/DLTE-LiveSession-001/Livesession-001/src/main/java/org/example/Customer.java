package org.example;

import java.util.ArrayList;

public class Customer {
    private int customer_id;
    private String customer_name, email, pan;
    private int  pin;
    private  long contact;

    public Customer(int customer_id, String customer_name, String email, String pan, long contact, int pin) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.email = email;
        this.pan = pan;
        this.contact = contact;
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", customer_name='" + customer_name + '\'' +
                ", email='" + email + '\'' +
                ", pan='" + pan + '\'' +
                ", contact=" + contact +
                ", pin=" + pin +
                '}';
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
