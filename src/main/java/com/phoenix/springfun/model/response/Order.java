package com.phoenix.springfun.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.phoenix.springfun.model.enums.OrderStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Document("order")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {

    @Id
    private String orderId;
    private Long orderNumber;
    private OrderStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String customer;
    private TaxAmounts taxAmounts;
    private BigDecimal totalTaxes;
    private BigDecimal totalAmount;
    private List<ProductQty> products;

    public Order(final String orderId, final Long orderNumber, final OrderStatus status, final LocalDateTime createdAt, final LocalDateTime updatedAt, final String customer, final TaxAmounts taxAmounts, final BigDecimal totalTaxes, final BigDecimal totalAmount, final List<ProductQty> products) {
        this.orderId = orderId;
        this.orderNumber = orderNumber;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.customer = customer;
        this.taxAmounts = taxAmounts;
        this.totalTaxes = totalTaxes;
        this.totalAmount = totalAmount;
        this.products = products;
    }

    public Order() {
        this.orderId = null;
        this.orderNumber = null;
        this.status = null;
        this.createdAt = null;
        this.updatedAt = null;
        this.customer = null;
        this.taxAmounts = null;
        this.totalTaxes = null;
        this.totalAmount = null;
        this.products = null;
    }

    public Order(final OrderStatus status, final LocalDateTime createdAt, final LocalDateTime updatedAt, final String customer, final TaxAmounts taxAmounts, final BigDecimal totalTaxes, final BigDecimal totalAmount, final List<ProductQty> products) {
        this.orderId = null;
        this.orderNumber = null;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.customer = customer;
        this.taxAmounts = taxAmounts;
        this.totalTaxes = totalTaxes;
        this.totalAmount = totalAmount;
        this.products = products;
    }

    public Order(final Long orderNumber, final OrderStatus status, final LocalDateTime createdAt, final LocalDateTime updatedAt, final String customer, final TaxAmounts taxAmounts, final BigDecimal totalTaxes, final BigDecimal totalAmount, final List<ProductQty> products) {
        this.orderId = null;
        this.orderNumber = orderNumber;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.customer = customer;
        this.taxAmounts = taxAmounts;
        this.totalTaxes = totalTaxes;
        this.totalAmount = totalAmount;
        this.products = products;
    }

    public Order(final Long orderNumber) {
        this.orderId = null;
        this.orderNumber = orderNumber;
        this.status = null;
        this.createdAt = null;
        this.customer = null;
        this.taxAmounts = null;
        this.totalTaxes = null;
        this.totalAmount = null;
        this.products = null;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setTaxAmounts(TaxAmounts taxAmounts) {
        this.taxAmounts = taxAmounts;
    }

    public void setTotalTaxes(BigDecimal totalTaxes) {
        this.totalTaxes = totalTaxes;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setProducts(List<ProductQty> products) {
        this.products = products;
    }

    public String getOrderId() {
        return orderId;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getCustomer() {
        return customer;
    }

    public TaxAmounts getTaxAmounts() {
        return taxAmounts;
    }

    public BigDecimal getTotalTaxes() {
        return totalTaxes;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public List<ProductQty> getProducts() {
        return products;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
