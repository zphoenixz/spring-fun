package com.phoenix.springfun.repository;


import com.phoenix.springfun.model.response.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    Order findTopByOrderByOrderIdDesc();
    Order findOrderByOrderNumber(final Long orderNumber);
}
