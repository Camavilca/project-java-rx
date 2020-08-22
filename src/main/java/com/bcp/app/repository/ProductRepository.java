package com.bcp.app.repository;

import io.reactivex.Flowable;
import org.springframework.data.repository.reactive.RxJava2CrudRepository;
import org.springframework.stereotype.Repository;
import com.bcp.app.document.Product;

@Repository
public interface ProductRepository extends RxJava2CrudRepository<Product, String> {
    Flowable<Product> findByCustomerId(String customerId);
}
