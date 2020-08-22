package com.bcp.app.controller;


import com.bcp.app.document.Customer;
import com.bcp.app.model.request.BaseResponse;
import com.bcp.app.service.customer.CustomerService;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping
	public Single<BaseResponse> create(@RequestBody Customer customer) {
		return customerService
				.create(customer)
				.subscribeOn(Schedulers.io())
				.map(o -> BaseResponse.successNoData());
	}

	@GetMapping
	public Flowable<BaseResponse> findAll() {
		return customerService
				.findAll()
				.subscribeOn(Schedulers.io())
				.map(credit -> BaseResponse.successWithData(credit));
	}

	@PutMapping
	public Single<BaseResponse> update(@RequestBody Customer customer) {
		return customerService
				.update(customer)
				.subscribeOn(Schedulers.io())
				.toSingle(() -> BaseResponse.successNoData());
	}

	@DeleteMapping("/{id}")
	public Single<BaseResponse> delete(@PathVariable String id) {
		return customerService
				.delete(id)
				.subscribeOn(Schedulers.io())
				.toSingle(() -> BaseResponse.successNoData());
	}

	@GetMapping("/{id}")
	public Single<BaseResponse> findById(@PathVariable String id) {
		return customerService
				.findById(id)
				.subscribeOn(Schedulers.io())
				.toSingle()
				.map(credit -> BaseResponse.successWithData(credit));
	}

}
