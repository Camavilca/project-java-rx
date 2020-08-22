package com.bcp.app.service.credit;

import com.bcp.app.document.Credit;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditService {
    Single<Credit> create(Credit credit);

    Flowable<Credit> findAll();

    Completable update(Credit credit);

    Completable delete(String id);

    Maybe<Credit> findById(String id);
}
