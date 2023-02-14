package com.nwmortgage.dao;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.nwmortgage.model.Loan;

@Repository
public interface AdminLoanRepo extends CrudRepository<Loan, Integer>{
//	Loan findByStatus(String status);
	
	Optional<Loan> findByLoanid(int loanid);

}
