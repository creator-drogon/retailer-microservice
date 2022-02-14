package com.config.server.controller;

import com.config.server.entity.Cart;
import com.config.server.entity.Customer;
import com.config.server.entity.LineItems;
import com.config.server.entity.Product;
import com.config.server.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/shoppingservice")
public class ShoppingController {

    @Autowired
    ShoppingService shoppingService;

    @PostMapping("/products")
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        ResponseEntity<?> response = shoppingService.createProduct(product);
        return response;
    }

    @PostMapping("/customer")
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer){
        ResponseEntity<?> response = shoppingService.createCustomer(customer);
        return response;
    }

    @PutMapping("/customer/{customerId}/cart")
    public ResponseEntity<?> addProductToCart(@RequestBody Cart cart, @PathVariable int customerId){
        ResponseEntity<?> response = shoppingService.addProductToCart(cart, customerId);
        return response;
    }

    @PostMapping("/customer/{customerId}/order")
    public ResponseEntity<?> createOrder(@PathVariable int customerId) throws Exception {
        ResponseEntity<?> response = shoppingService.createOrder(customerId);
        return response;
    }

    @GetMapping("/customer/{customerId}/orders")
    public ResponseEntity<?> getOrders(@PathVariable int customerId){
        ResponseEntity<?> response = shoppingService.getOrders(customerId);
        return response;
    }
}
