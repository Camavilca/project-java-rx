package com.bcp.app.service.credit;


import com.bcp.app.document.Credit;
import com.bcp.app.repository.CreditRepository;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    private CreditRepository creditRepository;

    @Override
    public Single<Credit> create(Credit credit) {
        return creditRepository.save(credit);
    }

    @Override
    public Flowable<Credit> findAll() {
        return creditRepository.findAll();
    }

    @Override
    public Completable update(Credit credit) {
        return creditRepository.save(credit).toCompletable();
    }

    @Override
    public Completable delete(String id) {
        return creditRepository.deleteById(id);
    }

    @Override
    public Maybe<Credit> findById(String id) {
        return creditRepository.findById(id);
    }
}
