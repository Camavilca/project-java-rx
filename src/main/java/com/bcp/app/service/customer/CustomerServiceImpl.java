package com.bcp.app.service.customer;

import com.bcp.app.document.Customer;
import com.bcp.app.repository.CustomerRepository;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Single<Customer> create(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Flowable<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Completable update(Customer customer) {
		return customerRepository.save(customer).toCompletable();
	}

	@Override
	public Completable delete(String id) {
		return customerRepository.deleteById(id);
	}

	@Override
	public Maybe<Customer> findById(String id) {
		return customerRepository.findById(id);
	}

	@Override
	public Maybe<Customer> findByDocumentNumber(String documentNumber) {
		return customerRepository.findByDocumentNumber(documentNumber);
	}
}
