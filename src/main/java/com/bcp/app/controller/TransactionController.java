package com.bcp.app.controller;


import com.bcp.app.document.Transaction;
import com.bcp.app.model.request.BaseResponse;
import com.bcp.app.service.transaction.TransactionService;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
   	public Single<BaseResponse> create(@RequestBody Transaction transaction) {
   		return transactionService
   				.create(transaction)
   				.subscribeOn(Schedulers.io())
   				.map(o -> BaseResponse.successNoData());
   	}

   	@GetMapping
   	public Flowable<BaseResponse> findAll() {
   		return transactionService
   				.findAll()
   				.subscribeOn(Schedulers.io())
   				.map(credit -> BaseResponse.successWithData(credit));
   	}

   	@PutMapping
   	public Single<BaseResponse> update(@RequestBody Transaction transaction) {
   		return transactionService
   				.update(transaction)
   				.subscribeOn(Schedulers.io())
   				.toSingle(() -> BaseResponse.successNoData());
   	}

   	@DeleteMapping("/{id}")
   	public Single<BaseResponse> delete(@PathVariable String id) {
   		return transactionService
   				.delete(id)
   				.subscribeOn(Schedulers.io())
   				.toSingle(() -> BaseResponse.successNoData());

   	}

   	@GetMapping("/{id}")
   	public Single<BaseResponse> findById(@PathVariable String id) {
   		return transactionService
   				.findById(id)
   				.subscribeOn(Schedulers.io()).toSingle()
   				.map(credit -> BaseResponse.successWithData(credit));
   	}
}
