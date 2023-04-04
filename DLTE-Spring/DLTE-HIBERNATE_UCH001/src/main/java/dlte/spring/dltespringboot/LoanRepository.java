
package dlte.spring.dltespringboot;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoanRepository extends CrudRepository<Loan,Long> {
    Optional<Loan> findByBorrowersName(String borrowersName);
    List<Loan> findAllByInterestRate(Integer interestRate);
    @Query("from Loan where interestRate> :min and interestRate< :max")
    List<Loan> findAllByRates(Integer min,Integer max);

}

