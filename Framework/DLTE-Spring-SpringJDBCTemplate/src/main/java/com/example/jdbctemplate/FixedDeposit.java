package com.example.jdbctemplate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FixedDeposit {

    private int deposit_id;
    private int deposit_amount;
    private int deposit_tenure;
    private Date deposit_date;
    private int Interest_rate;
    private Date mature_date;
    private int mature_amount;
    private String mode_of_dividant;

    public void setDeposit_id(int deposit_id) {
        this.deposit_id = deposit_id;
    }

    public void setDeposit_amount(int deposit_amount) {
        this.deposit_amount = deposit_amount;
    }

    public void setDeposit_tenure(int deposit_tenure) {
        this.deposit_tenure = deposit_tenure;
    }

    public void setDeposit_date(Date deposit_date) {
        this.deposit_date = deposit_date;
    }

    public void setInterest_rate(int interest_rate) {
        Interest_rate = interest_rate;
    }

    public void setMature_date(Date mature_date) {
        this.mature_date = mature_date;
    }

    public void setMature_amount(int mature_amount) {
        this.mature_amount = mature_amount;
    }

    public void setMode_of_dividant(String mode_of_dividant) {
        this.mode_of_dividant = mode_of_dividant;
    }

    public int getDeposit_id() {
        return deposit_id;
    }

    public int getDeposit_amount() {
        return deposit_amount;
    }

    public int getDeposit_tenure() {
        return deposit_tenure;
    }

    public Date getDeposit_date() {
        return deposit_date;
    }

    public int getInterest_rate() {
        return Interest_rate;
    }

    public Date getMature_date() {
        return mature_date;
    }

    public int getMature_amount() {
        return mature_amount;
    }

    public String getMode_of_dividant() {
        return mode_of_dividant;
    }
}

