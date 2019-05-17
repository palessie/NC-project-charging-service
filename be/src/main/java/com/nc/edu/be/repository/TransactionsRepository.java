package com.nc.edu.be.repository;

import com.nc.edu.be.entities.Transactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository  extends CrudRepository<Transactions, Integer>{
}
