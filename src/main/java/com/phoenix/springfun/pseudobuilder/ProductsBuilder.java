package com.phoenix.springfun.pseudobuilder;

import com.phoenix.springfun.model.request.schemas.CreateProductRequest;
import com.phoenix.springfun.model.request.schemas.PatchProductRequest;
import com.phoenix.springfun.model.response.Product;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class ProductsBuilder {
    public Product buildNewProduct(final CreateProductRequest createProductRequest) {
        return new Product(
                createProductRequest.getName(),
                createProductRequest.getCategory(),
                createProductRequest.getUnitPrice(),
                true,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    public Product buildPatchProduct(final Product productToPatch, final PatchProductRequest patchProductRequest) {
        return new Product(
                productToPatch.getProductId(),
                patchProductRequest.getName().orElse(productToPatch.getName()),
                patchProductRequest.getCategory().orElse(productToPatch.getCategory()),
                patchProductRequest.getUnitPrice().orElse(productToPatch.getUnitPrice()),
                patchProductRequest.getActive().orElse(productToPatch.getActive()),
                productToPatch.getCreatedAt(),
                LocalDateTime.now()
        );
    }
}
