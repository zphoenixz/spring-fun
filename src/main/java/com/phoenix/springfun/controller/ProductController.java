package com.phoenix.springfun.controller;

import com.phoenix.springfun.model.request.schemas.CreateProductRequest;
import com.phoenix.springfun.model.request.schemas.PatchProductRequest;
import com.phoenix.springfun.model.response.Product;
import com.phoenix.springfun.services.ProductService;
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
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    @PostMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public Product createProduct(final @Validated @RequestBody CreateProductRequest createProductRequest) throws Exception {
        logger.info("POST request to */api/v1/products ENDPOINT*");
        return productService.createProduct(createProductRequest);
    }

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Product> getProducts(final @RequestParam Optional<Integer> page) throws Exception {
        Integer requestedPage = page.orElse(0);
        logger.info("GET request to */api/v1/products?page=" + requestedPage + " ENDPOINT*");
        return productService.getProducts(requestedPage);
    }

    @GetMapping("{productId}")
    @ResponseStatus(code = HttpStatus.OK)
    public Product getProduct(final @PathVariable("productId") String productId) throws Exception {
        logger.info("GET request to */api/v1/products/" + productId + " ENDPOINT*");
        return productService.getProduct(productId);
    }

    @PatchMapping("{productId}")
    @ResponseStatus(code = HttpStatus.OK)//TODO CHANGE TO PATCH PRODUCT IN REQUEST BODY
    public Product patchProduct(final @PathVariable("productId") String productId, final @Validated @RequestBody PatchProductRequest patchProductRequest) throws Exception {
        logger.info("PATCH request to */api/v1/products/" + productId + " ENDPOINT*");
        return productService.patchProduct(productId, patchProductRequest);
    }

    @DeleteMapping("{productId}")
    @ResponseStatus(code = HttpStatus.OK)
    public Product deleteProduct(final @PathVariable("productId") String productId) throws Exception {
        logger.info("DELETE request to */api/v1/products/" + productId + " ENDPOINT*");
        return productService.deleteProduct(productId);
    }
}
