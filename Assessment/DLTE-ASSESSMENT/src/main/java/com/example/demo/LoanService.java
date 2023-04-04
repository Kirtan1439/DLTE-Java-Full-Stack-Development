package com.example.demo;

import java.util.List;

public class LoanService {
    public static Loans implementOfSave(Loans personalLoan) {
    }

    public static List<Loans> implementOfFetch() {
        return (List<Loans>) LoansRepository.findAll();
    }

    public static List<Loans> implementOfFindAllRejected() {
    }
}
