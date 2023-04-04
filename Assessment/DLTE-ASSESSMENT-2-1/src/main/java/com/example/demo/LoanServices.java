package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoanRepository extends CrudRepository<LoanModel,Integer> {

    @Query(value = "select * from LoanModel where cibil>700 and profession=('selfemployed','salaried') and income=(amt*3)", nativeQuery = true)
    Optional<LoanModel> findPersonalLoanApplicationByStatus(int cibil, String profession, int income);

    @Query(value = "select * from LoanModle where status=('rejected')", nativeQuery = true)
    List<String> findAllByStatus(String status);
}
