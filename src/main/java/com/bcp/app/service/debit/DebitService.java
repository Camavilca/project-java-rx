package com.bcp.app.service.debit;

import com.bcp.app.document.Debit;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;


public interface DebitService {
	
    Single<Debit> create(Debit debit);
    
    Flowable<Debit> findAll();

    Completable update(Debit debit);

    Completable delete(String id);

    Maybe<Debit> findById(String id);
}
