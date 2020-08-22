package com.bcp.app.repository;

import org.springframework.data.repository.reactive.RxJava2CrudRepository;
import org.springframework.stereotype.Repository;
import com.bcp.app.document.Transaction;

@Repository
public interface TransactionRepository extends RxJava2CrudRepository<Transaction, String> {
}
