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
import java.security.Principal;
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
    ResourceBundle bundle=ResourceBundle.getBundle("message");
    private Logger logger = LoggerFactory.getLogger(BankController.class);


        @GetMapping("/get")
    public List<Customer> callList() {
        logger.info("Controller about print all records");
        return bankService.listAll();
    }

    @GetMapping("/username")
    public String getUsername(Principal principal){
            return principal.getName();
    }


    //To list Transaction date from and to
    @GetMapping("/retrieve/{username}/{dateFrom}/{dateTo}")
    public List<Transaction> listTransactionDate(@PathVariable("username") String username,@PathVariable("dateFrom") String fromDate,@PathVariable("dateTo") String toDate) throws ParseException {
            logger.info("list of transaction date"+fromDate+toDate);
            List<Transaction> listDate=bankService.listDate(username,fromDate,toDate);
            logger.info(listDate.toString());
            return listDate;

    }
//    //To get Transaction list by username
//    @GetMapping("/list/{username}")
//    public List<Transaction> transactionList(@PathVariable("username")String username){
//            return null;
//    }



}