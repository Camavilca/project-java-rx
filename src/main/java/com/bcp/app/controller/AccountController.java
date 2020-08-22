package com.bcp.app.controller;

import com.bcp.app.model.dto.CreditAccount;
import com.bcp.app.model.dto.DebitAccount;
import com.bcp.app.model.request.BaseResponse;
import com.bcp.app.service.account.AccountService;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/debit",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Single<BaseResponse> createDebitAccount(@RequestBody DebitAccount debitAccount) {
        return accountService.createDebitAccount(debitAccount)
                .subscribeOn(Schedulers.io())
                .map(debitAccount1 -> BaseResponse.successNoData());
    }

    @PostMapping("/credit")
    public Single<BaseResponse> createCreditAccount(@RequestBody CreditAccount creditAccount) {
        return accountService.createCredittAccount(creditAccount)
                .subscribeOn(Schedulers.io())
                .map(creditAccount1 -> BaseResponse.successNoData());

    }
}
