package com.bcp.app.service.customer;

import com.bcp.app.document.Customer;

import io.reactivex.*;


public interface CustomerService {
	
    Single<Customer> create(Customer customer);

    Flowable<Customer> findAll();

    Completable update(Customer customer);

    Completable delete(String id);

    Maybe<Customer> findById(String id);

    Maybe<Customer> findByDocumentNumber(String documentNumber);
}
