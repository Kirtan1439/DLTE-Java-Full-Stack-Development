package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int customer_id;
    private String customer_name;
    private String customer_address;
    private String customer_status;
    private long contact;
    private String Username;
    private String password;



    public int getCustomer_id() {
        return customer_id;
    }

    public String getCustomer_name(String customer_name) {
        return this.customer_name;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public String getCustomer_status() {
        return customer_status;
    }

    public long getContact() {
        return contact;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return password;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public void setCustomer_status(String customer_status) {
        this.customer_status = customer_status;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", customer_name='" + customer_name + '\'' +
                ", customer_address='" + customer_address + '\'' +
                ", customer_status='" + customer_status + '\'' +
                ", contact=" + contact +
                ", Username='" + Username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


