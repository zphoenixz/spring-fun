package com.phoenix.springfun.repository;

import com.phoenix.springfun.model.response.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    Product findProductByProductId(String productId);

}
