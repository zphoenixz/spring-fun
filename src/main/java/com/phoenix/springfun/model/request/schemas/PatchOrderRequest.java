package com.phoenix.springfun.model.request.schemas;

import com.phoenix.springfun.model.enums.Category;
import com.phoenix.springfun.model.enums.OrderStatus;
import com.phoenix.springfun.model.response.Product;
import com.phoenix.springfun.model.response.ProductQty;
import com.phoenix.springfun.utils.constants.Regex;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PatchOrderRequest {

    @Pattern(regexp = Regex.STATUS)
    private String status;

    @Valid
    private List<ProductByIdRequest> products;


    public Optional<OrderStatus> getStatus() {
        return Optional.ofNullable(OrderStatus.fromText(status));
    }

    public List<ProductQty> getProducts() {
        return products != null ?
                products
                        .stream()
                        .map(e -> new ProductQty(
                                new Product(e.getProductId()),
                                e.getQty())
                        )
                        .collect(Collectors.toList())
                : null;
    }
}
