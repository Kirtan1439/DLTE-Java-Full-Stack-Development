package dlte.spring.dltespringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;

    public List<Loan> implementationOfFindAll()
    {
        return (List<Loan>) loanRepository.findAll();
    }

    public Loan implementationOfSave(Loan loan)
    {
        return loanRepository.save(loan);
    }

    public String implementOfDeleteById(long loanNumber)
    {
        loanRepository.deleteById(loanNumber);
        return "Deleted";
    }

    public Optional<Loan> implementOfFindByBorrowerName(String borrowersName)
    {
        return loanRepository.findByBorrowersName(borrowersName);
    }

    public  List<Loan> implementOfFindAllByInterestRate(Integer interestRate)
    {
        return loanRepository.findAllByInterestRate(interestRate);
    }

}