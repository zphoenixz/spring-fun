package com.phoenix.springfun.model.request.schemas;

import com.phoenix.springfun.model.response.Product;
import com.phoenix.springfun.model.response.ProductQty;
import com.phoenix.springfun.utils.constants.Regex;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.stream.Collectors;
public class CreateOrderRequest {

    @NotNull(message = "A customer field is required")
    @Pattern(regexp = Regex.TRIMMED_NO_BLANK_MIN_1_MAX_256_W_WHITESPACE)
    private String customer;

    @Valid
    @NotNull(message = "A products field is required")
    private List<ProductByIdRequest> products;


    public String getCustomer() {
        return customer;
    }
    
    public List<ProductQty> getProducts() {
        return products
                .stream()
                .map(e -> new ProductQty(
                        new Product(e.getProductId()),
                        e.getQty())
                )
                .collect(Collectors.toList());
    }
}
