package bank.project.app;

import bank.project.dao.BankService;
import bank.project.dao.Customer;
import bank.project.dao.Transaction;
import org.omg.IOP.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

@ComponentScan("bank.project.dao")
@RestController
@RequestMapping("/app")
public class BankController {

    @Autowired
    private BankService bankService;

//    @Autowired
//    private TransactionService transactionService;

    ResourceBundle bundle=ResourceBundle.getBundle("message");
    private Logger logger = LoggerFactory.getLogger(BankController.class);


        @GetMapping("/get")
    public List<Customer> callList() {
        logger.info("Controller about print all records");
        return bankService.listAll();
    }
    @PostMapping("/login")
    public String authenticate(@RequestParam("username") String username, @RequestParam("password") String password) {
        logger.info("Entered sampled function");
        Customer customer = bankService.getByUsername(username);
        if (customer == null){
            logger.info(bundle.getString("notExist"));
            return bundle.getString("notExist");
        }

        else {
            logger.info(customer.getCustomer_status());
            if (customer.getCustomer_status().equalsIgnoreCase("Inactive")) {
                logger.info(bundle.getString("inactive"));
                return bundle.getString("inactive");
            }


            if (!password.equals(customer.getPassword())) {
                bankService.incrementFailedAttempts(customer.getCustomer_id());
                int attempts = bankService.getAttempts(customer.getCustomer_id());
                if (attempts==2) {
                    logger.info(bundle.getString("pass") + bundle.getString("attempt1"));
                    return bundle.getString("pass") + bundle.getString("attempt1");
                }
             else if (attempts==1) {
                logger.info(bundle.getString("pass") + bundle.getString("attempt2"));
                return bundle.getString("pass") + bundle.getString("attempt2");
            }
            else
                {
                logger.info(bundle.getString("inactive"));
                return bundle.getString("inactive");
            }
        }
        else{
            bankService.setAttempts(customer.getCustomer_id());
            logger.info(bundle.getString("Success"));
            return bundle.getString("Success");

        }
        }
    }
    @GetMapping("/retrieve/{username}/{dateFrom}/{dateTo}")
    public List<Transaction> callTransaction(@PathVariable("username") String username,@PathVariable("dateFrom") String fromDate,@PathVariable("dateTo") String toDate) throws ParseException {
            logger.info("list of transaction date"+fromDate+toDate);
            List<Transaction> listDate=bankService.listDate(username,fromDate,toDate);
            logger.info(listDate.toString());
            return listDate;

    }
    @GetMapping("/list/{username}")
    public List<Transaction> transactionList(@PathVariable("username")String username){
            return null;
    }
//    @GetMapping("/gets/{username}") //to take value VIA ajax
//    public List<Transaction> callListOfTransaction(@PathVariable("username") String username,) {
//        List<Transaction> listTransaction=bankService.listAmount();//create object
//
//        return listTransaction; //return object
//
//    }

}