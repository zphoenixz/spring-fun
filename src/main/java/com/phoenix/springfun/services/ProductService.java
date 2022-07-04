package com.phoenix.springfun.services;

import com.phoenix.springfun.handler.exceptions.ApiRestException;
import com.phoenix.springfun.model.request.schemas.CreateProductRequest;
import com.phoenix.springfun.model.request.schemas.PatchProductRequest;
import com.phoenix.springfun.model.response.Product;

import java.util.List;


public interface ProductService {
    Product createProduct(final CreateProductRequest createProductRequest) throws ApiRestException;
    List<Product> getProducts(final Integer requestedPage)throws ApiRestException;
    Product getProduct(final String productId)throws ApiRestException;
    Product patchProduct(final String productId, final PatchProductRequest patchProductRequest)throws ApiRestException;
    Product deleteProduct(final String productId)throws ApiRestException;
}
