package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {
    @Autowired
    private LoanService loanService;

    @GetMapping("/retrieve")
    public List<Loans> callingFetch(){
        return LoanService.implementOfFetch();
    }

    @PostMapping("/insert")
    public Loans callingSave(@RequestBody Loans personalLoan){
        return LoanService.implementOfSave(personalLoan);
    }

    @GetMapping("/rejected")
    public List<Loans> callingFindAllRejected(){
        return LoanService.implementOfFindAllRejected();
    }

    public LoanService getLoanService() {
        return loanService;
    }
}
