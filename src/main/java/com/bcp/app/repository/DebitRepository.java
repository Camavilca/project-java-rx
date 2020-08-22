package com.bcp.app.repository;

import org.springframework.data.repository.reactive.RxJava2CrudRepository;
import org.springframework.stereotype.Repository;
import com.bcp.app.document.Debit;

@Repository
public interface DebitRepository extends RxJava2CrudRepository<Debit, String> {
}
