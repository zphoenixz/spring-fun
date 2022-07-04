package com.phoenix.springfun.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.phoenix.springfun.model.enums.Category;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document("product")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Product {

    @Id
    private String productId;
    private String name;
    private Category category;
    private Double unitPrice;
    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Product() {
        this.productId = null;
        this.name = null;
        this.category = null;
        this.unitPrice = null;
        this.active = null;
        this.createdAt = null;
        this.updatedAt = null;
    }

    public Product(final String productId) {
        this.productId = productId;
        this.name = null;
        this.category = null;
        this.unitPrice = null;
        this.active = null;
        this.createdAt = null;
        this.updatedAt = null;
    }

    public Product(final String productId, final String name, final Category category, final double unitPrice, final boolean active, final LocalDateTime createdAt, final LocalDateTime updatedAt) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.unitPrice = unitPrice;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Product(final String name, final Category category, final double unitPrice, final boolean active, final LocalDateTime createdAt, final LocalDateTime updatedAt) {
        this.productId = null;
        this.name = name;
        this.category = category;
        this.unitPrice = unitPrice;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
