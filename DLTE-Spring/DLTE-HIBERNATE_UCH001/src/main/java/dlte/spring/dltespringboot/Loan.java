package dlte.spring.dltespringboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "loan_seq")
    private long loanNumber;
    @Column(nullable = false)
    private String borrowersName;
    @Column(nullable = false)
    private int interestRate;
    @Column(nullable = false)
    private int  passedTenure;
    @Column(nullable = false)
    private int failedTenure;
    @Column(nullable = false)
    private String loanType;
    @Column(nullable = false)
    private int totalTenure;
    @Column(nullable = false)
    private int loanAmount;
}