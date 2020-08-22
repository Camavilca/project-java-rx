package com.bcp.app.service.product;

import com.bcp.app.document.Product;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface ProductService {
	Single<Product> create(Product product);

	Flowable<Product> findAll();

	Completable update(Product product);

	Completable delete(String id);

	Maybe<Product> findById(String id);

	Flowable<Product> findByCustomerId(String customerId);
}
