package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Loans {
    @Id
    @NonNull
    private long loanNumber;
    @Column(nullable = false)
    private String request_num;
    @Column(nullable = false)
    private int cibil;
    @Column(nullable = false)
    private int addhar;
    @Column(nullable = false)
    private String pan;
    @Column(nullable = false)
    private String profession;
    @Column(nullable = false)
    private String loanType;
    @Column(nullable = false)
    private String date;

    private int income;

    @Override
    public String toString() {
        return "Loans{" +
                "loanNumber=" + loanNumber +
                ", request_num='" + request_num + '\'' +
                ", cibil=" + cibil +
                ", addhar=" + addhar +
                ", pan='" + pan + '\'' +
                ", profession='" + profession + '\'' +
                ", loanType='" + loanType + '\'' +
                ", date='" + date + '\'' +
                ", income=" + income +
                '}';
    }

    public long getLoanNumber() {
        return loanNumber;
    }

    public String getRequest_num() {
        return request_num;
    }

    public int getCibil() {
        return cibil;
    }

    public int getAddhar() {
        return addhar;
    }

    public String getPan() {
        return pan;
    }

    public String getProfession() {
        return profession;
    }

    public String getLoanType() {
        return loanType;
    }

    public String getDate() {
        return date;
    }

    public int getIncome() {
        return income;
    }

    public void setLoanNumber(long loanNumber) {
        this.loanNumber = loanNumber;
    }

    public void setRequest_num(String request_num) {
        this.request_num = request_num;
    }

    public void setCibil(int cibil) {
        this.cibil = cibil;
    }

    public void setAddhar(int addhar) {
        this.addhar = addhar;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setIncome(int income) {
        this.income = income;
    }
}


