package com.bcp.app.controller;

import com.bcp.app.document.Credit;
import com.bcp.app.model.request.BaseResponse;
import com.bcp.app.service.credit.CreditService;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/credit")
public class CreditController {

    @Autowired
    private CreditService creditService;

    @PostMapping(
    		consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Single<BaseResponse> create(@RequestBody Credit credit) {
        return creditService.create(credit)
                .subscribeOn(Schedulers.io())
                .map(o -> BaseResponse.successNoData());
    }

    @GetMapping
    public Flowable<BaseResponse> findAll() {
        return creditService.findAll()
                .subscribeOn(Schedulers.io())
                .map(credit -> BaseResponse.successWithData(credit));
    }

    @PutMapping
    public Single<BaseResponse> update(@RequestBody Credit credit) {
        return creditService.update(credit)
                .subscribeOn(Schedulers.io())
                .toSingle(() -> BaseResponse.successNoData());
    }

    @DeleteMapping("/{id}")
    public Single<BaseResponse> delete(@PathVariable String id) {
        return creditService.delete(id)
                .subscribeOn(Schedulers.io())
                .toSingle(() -> BaseResponse.successNoData());

    }

    @GetMapping("/{id}")
    public Single<BaseResponse> findById(@PathVariable String id) {
        return creditService.findById(id)
                .subscribeOn(Schedulers.io())
                .toSingle()
                .map(credit -> BaseResponse.successWithData(credit));
    }
}
