package com.phoenix.springfun.model.request.schemas;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.phoenix.springfun.model.response.Product;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductByIdRequest {

    @NotNull(message = "A productId field is required")
    private String productId;

    @NotNull(message = "A qty field is required")
    private Integer qty;

    public String getProductId(){
        return productId;
    };

    public Integer getQty() {
        return qty;
    }
}
