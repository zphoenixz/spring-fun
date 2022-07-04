package com.phoenix.springfun.services.impl;

import com.phoenix.springfun.model.request.schemas.PatchOrderRequest;
import com.phoenix.springfun.model.response.Product;
import com.phoenix.springfun.model.response.ProductQty;
import com.phoenix.springfun.model.response.TaxAmounts;
import com.phoenix.springfun.pseudobuilder.OrdersBuilder;
import com.phoenix.springfun.handler.exceptions.ApiRestException;
import com.phoenix.springfun.model.request.schemas.CreateOrderRequest;
import com.phoenix.springfun.model.response.Order;
import com.phoenix.springfun.pseudobuilder.TaxAmountsBuilder;
import com.phoenix.springfun.repository.OrderRepository;
import com.phoenix.springfun.repository.ProductRepository;
import com.phoenix.springfun.services.OrderService;
import com.phoenix.springfun.utils.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrdersBuilder ordersBuilder;
    @Autowired
    private TaxAmountsBuilder taxAmountsBuilder;


    @Override
    public Order createOrder(final CreateOrderRequest rawOrderRequest) throws ApiRestException {

        if(!(rawOrderRequest.getProducts().size() > 0)){
            throw new ApiRestException("No product is sent in this order");
        }

        final List<ProductQty> productsInOrder = getProducts(rawOrderRequest.getProducts());
        final BigDecimal orderSubTotal = getSubtotalFromProducts(productsInOrder);
        final TaxAmounts taxAmounts = taxAmountsBuilder.buildTaxesAmounts(orderSubTotal);
        final Order previousOrder = orderRepository.findTopByOrderByOrderIdDesc();
        long lastOrderNumber = previousOrder.getOrderNumber();
        final Order newOrder = ordersBuilder.buildNewOrder(rawOrderRequest, taxAmounts, orderSubTotal, productsInOrder, lastOrderNumber + 1);

        return orderRepository.save(newOrder);
    }

    @Override
    public List<Order> getOrders(final Integer requestedPage) throws ApiRestException {
        final PageRequest request =  PageRequest.of(requestedPage, Constants.pageSize, Sort.by(Sort.Direction.DESC, "updatedAt"));
        return orderRepository.findAll(request).getContent();
    }

    @Override
    public Order getOrder(final Long orderNumber) throws ApiRestException {
        final Order orderToGet = orderRepository.findOrderByOrderNumber(orderNumber);
        if(orderToGet == null){
            throw new ApiRestException("Order not found.");
        }
        return orderToGet;
    }

    @Override
    public Order patchOrder(final Long orderNumber, final PatchOrderRequest patchOrderRequest)throws ApiRestException{

        final Order orderToPatch = orderRepository.findOrderByOrderNumber(orderNumber);
        if(orderToPatch == null){
            throw new ApiRestException("Order not found.");
        }

        List<ProductQty> productsInOrder= null;
        BigDecimal orderSubTotal= null;
        TaxAmounts taxAmounts = null;
        if(patchOrderRequest.getProducts() != null){
            if(!(patchOrderRequest.getProducts().size() > 0)){
                throw new ApiRestException("No product is sent in this order");
            }
            productsInOrder = getProducts(patchOrderRequest.getProducts());
            orderSubTotal = getSubtotalFromProducts(productsInOrder);
            taxAmounts = taxAmountsBuilder.buildTaxesAmounts(orderSubTotal);
        }
        final Order patchedOrder = ordersBuilder.buildPatchOrder(orderToPatch, patchOrderRequest, taxAmounts, orderSubTotal, productsInOrder);

        return orderRepository.save(patchedOrder);
    }

    @Override
    public Order deleteOrder(final Long orderNumber)throws ApiRestException{
        final Order orderToDelete= orderRepository.findOrderByOrderNumber(orderNumber);
        if(orderToDelete == null){
            throw new ApiRestException("Order not found.");
        }
        orderRepository.delete(orderToDelete);
        return new Order();
    }

    private List<ProductQty> getProducts(final List<ProductQty> rawProductsQty) throws ApiRestException{
        final List<ProductQty> productsQty = new ArrayList<>();
        for (ProductQty productQty : rawProductsQty) {
            final Product currentProduct = productRepository.findProductByProductId(productQty.getProduct().getProductId());
            if (currentProduct == null) {
                throw new ApiRestException("Invalid productID " + productQty.getProduct().getProductId());
            }
            if (!currentProduct.getActive()) {
                throw new ApiRestException("Is not available, productID " + productQty.getProduct().getProductId());
            }
            productsQty.add(
                    new ProductQty(
                            currentProduct,
                            productQty.getQty()
                    )
            );
        }
        return productsQty;
    }

    private BigDecimal getSubtotalFromProducts(final List<ProductQty> productsInOrder) throws ApiRestException{
        Double subTotal = 0.0;
        for (ProductQty productQty : productsInOrder) {
            subTotal += (productQty.getProduct().getUnitPrice() * productQty.getQty());
        }
        return new BigDecimal(subTotal);
    }
}
