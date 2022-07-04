package com.phoenix.springfun.controller;

import com.phoenix.springfun.model.request.schemas.CreateOrderRequest;
import com.phoenix.springfun.model.request.schemas.PatchOrderRequest;
import com.phoenix.springfun.model.response.Order;
import com.phoenix.springfun.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@CrossOrigin
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    private Logger logger = LoggerFactory.getLogger(OrderController.class);

    @PostMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public Order createOrder(@Validated @RequestBody CreateOrderRequest createOrderRequest) throws Exception {
        logger.info("POST request to */api/v1/orders ENDPOINT*");
        return orderService.createOrder(createOrderRequest);
    }

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Order> getOrders(final @RequestParam Optional<Integer> page) throws Exception {
        Integer requestedPage = page.orElse(0);
        logger.info("GET request to */api/v1/orders?page=" + requestedPage + " ENDPOINT*");
        return orderService.getOrders(requestedPage);
    }

    @GetMapping("{orderNumber}")
    @ResponseStatus(code = HttpStatus.OK)
    public Order getOrder(final @PathVariable("orderNumber") Long orderNumber) throws Exception {
        logger.info("GET request to */api/v1/orders/" + orderNumber + " ENDPOINT*");
        return orderService.getOrder(orderNumber);
    }

    @PatchMapping("{orderNumber}")
    @ResponseStatus(code = HttpStatus.OK)
    public Order patchOrder(final @PathVariable("orderNumber") Long orderNumber, final @Validated @RequestBody PatchOrderRequest patchOrderRequest) throws Exception {
        logger.info("PATCH request to */api/v1/orders/" + orderNumber + " ENDPOINT*");
        return orderService.patchOrder(orderNumber, patchOrderRequest);
    }

    @DeleteMapping("{orderNumber}")
    @ResponseStatus(code = HttpStatus.OK)
    public Order deleteOrder(final @PathVariable("orderNumber") Long orderNumber) throws Exception {
        logger.info("DELETE request to */api/v1/orders/" + orderNumber + " ENDPOINT*");
        return orderService.deleteOrder(orderNumber);
    }
}
