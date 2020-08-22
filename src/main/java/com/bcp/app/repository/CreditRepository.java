package com.bcp.app.repository;

import org.springframework.data.repository.reactive.RxJava2SortingRepository;
import org.springframework.stereotype.Repository;

import com.bcp.app.document.Credit;

@Repository
public interface CreditRepository extends RxJava2SortingRepository<Credit, String> {
}
