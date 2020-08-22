package com.bcp.app.service.debit;

import com.bcp.app.document.Debit;
import com.bcp.app.repository.DebitRepository;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DebitServiceImpl implements DebitService {

	@Autowired
	private DebitRepository debitRepository;

	@Override
	public Single<Debit> create(Debit debit) {
		return debitRepository.save(debit);
	}

    @Override
    public Flowable<Debit> findAll() {
        return debitRepository.findAll();
    }

	@Override
	public Completable update(Debit debit) {
		return debitRepository.save(debit).toCompletable();
	}

	@Override
	public Completable delete(String id) {
		return debitRepository.deleteById(id);
	}

	@Override
	public Maybe<Debit> findById(String id) {
		return debitRepository.findById(id);
	}
}
