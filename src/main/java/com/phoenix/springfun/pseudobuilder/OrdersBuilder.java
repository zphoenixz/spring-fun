package com.phoenix.springfun.pseudobuilder;

import com.phoenix.springfun.model.enums.OrderStatus;
import com.phoenix.springfun.model.request.schemas.CreateOrderRequest;
import com.phoenix.springfun.model.request.schemas.PatchOrderRequest;
import com.phoenix.springfun.model.response.Order;
import com.phoenix.springfun.model.response.ProductQty;
import com.phoenix.springfun.model.response.TaxAmounts;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Component
public class OrdersBuilder {

    public Order buildNewOrder(final CreateOrderRequest rawOrder, final TaxAmounts taxAmounts, final BigDecimal subTotal, final List<ProductQty> productsInOrder, final Long orderNumber){
        return new Order(
                orderNumber,
                OrderStatus.PENDING,
                LocalDateTime.now(),
                LocalDateTime.now(),
                rawOrder.getCustomer(),
                taxAmounts,
                taxAmounts.getTotalTaxes(),
                subTotal.add(taxAmounts.getTotalTaxes()),
                productsInOrder
        );
    }

    public Order buildPatchOrder(final Order orderToPatch, final PatchOrderRequest patchOrderRequest, final TaxAmounts taxAmounts, final BigDecimal subTotal, final List<ProductQty> newProductsInOrder ) {
        return new Order(
                orderToPatch.getOrderId(),
                orderToPatch.getOrderNumber(),
                patchOrderRequest.getStatus().orElse(orderToPatch.getStatus()),
                orderToPatch.getCreatedAt(),
                LocalDateTime.now(),
                orderToPatch.getCustomer(),
                taxAmounts != null ? taxAmounts : orderToPatch.getTaxAmounts(),
                taxAmounts != null ? taxAmounts.getTotalTaxes() : orderToPatch.getTotalTaxes(),
                taxAmounts != null ? subTotal.add(taxAmounts.getTotalTaxes()) : orderToPatch.getTotalAmount(),
                newProductsInOrder != null ? newProductsInOrder : orderToPatch.getProducts()
        );
    }
}
