package com.bcp.app.service.transaction;

import com.bcp.app.document.Transaction;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {
    Single<Transaction> create(Transaction transaction);

    Flowable<Transaction> findAll();

    Completable update(Transaction transaction);

    Completable delete(String id);

    Maybe<Transaction> findById(String id);
}
