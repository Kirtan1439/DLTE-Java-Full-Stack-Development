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
public class LoanModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "loan_sequence")
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

    public long getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(long loanNumber) {
        this.loanNumber = loanNumber;
    }

    public String getRequest_num() {
        return request_num;
    }

    public void setRequest_num(String request_num) {
        this.request_num = request_num;
    }

    public int getCibil() {
        return cibil;
    }

    public void setCibil(int cibil) {
        this.cibil = cibil;
    }

    public int getAddhar() {
        return addhar;
    }

    public void setAddhar(int addhar) {
        this.addhar = addhar;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;

    }

    @Override
    public String toString() {
        return "LoanModel{" +
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
}

