package bank.app.bankapplication;

import com.example.demo.BankService;
import com.example.demo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@ComponentScan("com.example.demo")
@RestController
public class BankController {
    @Autowired
    private BankService bankService;

    @GetMapping("/")
    public List<Customer> callList(){
        return bankService.listAll();
    }



}
