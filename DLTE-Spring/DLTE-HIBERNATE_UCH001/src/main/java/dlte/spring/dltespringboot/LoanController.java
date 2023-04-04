package dlte.spring.dltespringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LoanController {
    @Autowired
    private LoanService loanService;


    @PostMapping("/insert")
    public Loan callingSave(@RequestBody Loan loan)
    {
        return loanService.implementationOfSave(loan);
    }

    @GetMapping("/retrieve")
    public List<Loan> callingFindAll(){
        return loanService.implementationOfFindAll();

    }
    @DeleteMapping("/suspend/{loanNumber}")
    public String callDeleteById(@PathVariable("loanNumber") long loanNumber)
    {
        return loanService.implementOfDeleteById(loanNumber);
    }

    @GetMapping("/name/{borrowerName}")
    public Optional<Loan> callingFindByLoanName(@PathVariable("borrowerName") String borrowersName)
    {
        return loanService.implementOfFindByBorrowerName(borrowersName);
    }

    @GetMapping("/rate/{interestRate}")
    public  List<Loan> callingFindAllByInterestRate(@PathVariable("interestRate") Integer interestRate)
    {
        return loanService.implementOfFindAllByInterestRate(interestRate);
    }


}