package com.example.demo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface LoanRepository extends CrudRepository<LoanModel,Integer> {

    @Query("from LoanModel where statusOfApproval='Rejected'")
    List<LoanModel> findAllRejected();

}
