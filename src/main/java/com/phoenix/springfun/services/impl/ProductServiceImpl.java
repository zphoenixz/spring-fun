package com.phoenix.springfun.services.impl;

import com.phoenix.springfun.handler.exceptions.ApiRestException;
import com.phoenix.springfun.model.request.schemas.CreateProductRequest;
import com.phoenix.springfun.model.request.schemas.PatchProductRequest;
import com.phoenix.springfun.model.response.Product;
import com.phoenix.springfun.pseudobuilder.ProductsBuilder;
import com.phoenix.springfun.repository.ProductRepository;
import com.phoenix.springfun.services.ProductService;
import com.phoenix.springfun.utils.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private ProductsBuilder productsBuilder;

    @Override
    public Product createProduct(final CreateProductRequest createProductRequest) throws ApiRestException {
        final Product newProduct = productsBuilder.buildNewProduct(createProductRequest);
        return repository.save(newProduct);
    }

    @Override
    public Product getProduct(final String productId) throws ApiRestException {
        final Product productToGet = repository.findProductByProductId(productId);
        if(productToGet == null){
            throw new ApiRestException("Product not found.");
        }
        return productToGet;
    }

    @Override
    public List<Product> getProducts(final Integer requestedPage) throws ApiRestException {
        final PageRequest request =  PageRequest.of(requestedPage, Constants.pageSize, Sort.by(Sort.Direction.DESC, "updatedAt"));
        return repository.findAll(request).getContent();
    }

    @Override
    public Product patchProduct(final String productId, final PatchProductRequest patchProductRequest)throws ApiRestException{
        final Product productToPatch = repository.findProductByProductId(productId);
        if(productToPatch == null){
            throw new ApiRestException("Product not found.");
        }
        final Product patchedProduct = productsBuilder.buildPatchProduct(productToPatch, patchProductRequest);
        return repository.save(patchedProduct);
    }

    @Override
    public Product deleteProduct(final String productId)throws ApiRestException{
        final Product productToDelete= repository.findProductByProductId(productId);
        if(productToDelete == null){
            throw new ApiRestException("Product not found.");
        }
        repository.delete(productToDelete);
        return new Product();
    }
}
