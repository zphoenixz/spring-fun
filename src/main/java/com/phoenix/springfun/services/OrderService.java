package com.phoenix.springfun.services;

import com.phoenix.springfun.handler.exceptions.ApiRestException;
import com.phoenix.springfun.model.request.schemas.CreateOrderRequest;
import com.phoenix.springfun.model.request.schemas.PatchOrderRequest;
import com.phoenix.springfun.model.response.Order;

import java.util.List;


public interface OrderService {
    Order createOrder(final CreateOrderRequest createOrderRequest) throws ApiRestException;
    List<Order> getOrders(final Integer requestedPage)throws ApiRestException;
    Order getOrder(final Long orderNumber)throws ApiRestException;
    Order patchOrder(final Long orderNumber, final PatchOrderRequest patchOrderRequest)throws ApiRestException;
    Order deleteOrder(final Long orderNumber)throws ApiRestException;
}
