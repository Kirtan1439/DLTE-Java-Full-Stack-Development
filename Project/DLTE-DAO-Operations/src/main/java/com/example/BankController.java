package com.example;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.logging.Logger;

public class BankController {
    @Autowired
    public BankService bankService;

    private Logger logger= (Logger) LoggerFactory.getLogger(BankController.class);

    @GetMapping("/")
    public Optional<Customer> callList(){
        logger.info("Controller about to find records");
        return bankService.listAll();
    }
}
