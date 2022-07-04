package com.phoenix.springfun.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductQty {
    private Product product;
    private Integer qty;

    public ProductQty() {
        this.product = null;
        this.qty = null;
    }

    public ProductQty(Product product, Integer qty) {
        this.product = product;
        this.qty = qty;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
