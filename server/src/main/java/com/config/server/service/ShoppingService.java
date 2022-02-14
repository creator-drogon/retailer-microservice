package com.config.server.service;

import com.config.server.entity.Cart;
import com.config.server.entity.Customer;
import com.config.server.entity.LineItems;
import com.config.server.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ShoppingService {

    ResponseEntity<?> createProduct(Product product);

    ResponseEntity<?> createCustomer(Customer customer);

    ResponseEntity<?> addProductToCart(Cart cart, int customerId);

    ResponseEntity<?> createOrder(int customerId) throws Exception;

    ResponseEntity<?> getOrders(int customerId);
}
