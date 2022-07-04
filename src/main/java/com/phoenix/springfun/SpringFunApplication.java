package com.phoenix.springfun;


import com.phoenix.springfun.model.response.Order;
import com.phoenix.springfun.repository.OrderRepository;
import com.phoenix.springfun.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringFunApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringFunApplication.class, args);
    }

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void seedMongoRepos() {
//        orderRepository.deleteAll();
//        productRepository.deleteAll();
//        orderRepository.save(new Order(0L));
    }
}

