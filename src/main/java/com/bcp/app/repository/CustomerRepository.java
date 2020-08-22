package com.bcp.app.repository;

import io.reactivex.Maybe;
import io.reactivex.Single;
import org.springframework.data.repository.reactive.RxJava2CrudRepository;
import org.springframework.stereotype.Repository;

import com.bcp.app.document.Customer;

@Repository
public interface CustomerRepository extends RxJava2CrudRepository<Customer, String> {
    Maybe<Customer> findByDocumentNumber(String documentNumber);
}
