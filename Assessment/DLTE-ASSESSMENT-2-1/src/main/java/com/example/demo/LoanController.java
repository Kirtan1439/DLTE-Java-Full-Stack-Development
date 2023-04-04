package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoanController {
    @Autowired
    private PersonalLoanService personalLoanService;

    @GetMapping("/retrieve")
    public List<LoanModel> callingFetch(){
        return PersonalLoanService.implementOfFetch();
    }

    @PostMapping("/insert")
    public LoanModel callingSave(@RequestBody LoanModel personalLoan){
        return PersonalLoanService.implementOfSave(personalLoan);
    }

    @GetMapping("/rejected")
    public List<LoanModel> callingFindAllRejected(){
        return PersonalLoanService.implementOfFindAllRejected();
    }
}
