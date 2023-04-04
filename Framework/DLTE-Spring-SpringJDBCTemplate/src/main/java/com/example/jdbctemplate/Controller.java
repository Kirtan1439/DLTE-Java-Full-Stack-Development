package com.example.jdbctemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private FixedDepositServices fixedDepositServices;


    @GetMapping("/created/{amount}")
    public List<FixedDeposit> callFetchDate(@PathVariable("amount")int amount){
        return fixedDepositServices.fixedDep(amount);
    }
}
