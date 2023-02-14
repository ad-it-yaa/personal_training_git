package com.nwmortgage.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.nwmortgage.model.Loan;

@Repository
public interface LoanRepo extends CrudRepository<Loan, Integer>
{


	
}
