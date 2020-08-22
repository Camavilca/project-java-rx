package com.bcp.app.service.transaction;


import com.bcp.app.document.Transaction;
import com.bcp.app.repository.TransactionRepository;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Single<Transaction> create(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Flowable<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Completable update(Transaction transaction) {
        return transactionRepository.save(transaction).toCompletable();
    }

    @Override
    public Completable delete(String id) {
        return transactionRepository.deleteById(id);
    }

    @Override
    public Maybe<Transaction> findById(String id) {
        return transactionRepository.findById(id);
    }
}
