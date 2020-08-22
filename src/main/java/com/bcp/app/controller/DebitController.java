package com.bcp.app.controller;


import com.bcp.app.document.Debit;
import com.bcp.app.model.request.BaseResponse;
import com.bcp.app.service.debit.DebitService;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/debit")
public class DebitController {

	@Autowired
	private DebitService debitService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Single<BaseResponse> create(@RequestBody Debit debit) {
		return debitService
				.create(debit)
				.subscribeOn(Schedulers.io())
				.map(debitAccount1 -> BaseResponse.successNoData());
	}

	@GetMapping
	public Flowable<BaseResponse> findAll() {
		return debitService
				.findAll()
				.subscribeOn(Schedulers.io())
				.map(credit -> BaseResponse.successWithData(credit));
	}

	@PutMapping
	public Single<BaseResponse> update(@RequestBody Debit debit) {
		return debitService
				.update(debit)
				.subscribeOn(Schedulers.io())
				.toSingle(() -> BaseResponse.successNoData());
	}

	@DeleteMapping("/{id}")
	public Single<BaseResponse> delete(@PathVariable String id) {
		return debitService
				.delete(id)
				.subscribeOn(Schedulers.io())
				.toSingle(() -> BaseResponse.successNoData());

	}

	@GetMapping("/{id}")
	public Single<BaseResponse> findById(@PathVariable String id) {
		return debitService
				.findById(id)
				.subscribeOn(Schedulers.io()).toSingle()
				.map(credit -> BaseResponse.successWithData(credit));
	}

}
