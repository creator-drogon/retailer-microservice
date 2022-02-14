package com.cart.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cart.dto.cartProduct;
import com.cart.entity.Cart;
import com.cart.service.cartService;
@RestController
public class CartController {
@Autowired
cartService cservice;
@PostMapping("/addtocart")
public Cart addTocart(@RequestBody Cart cp) {
	return cservice.addToCart(cp);
}
@GetMapping("/getcartdetails")
public List<Cart> getcartdetails(){
	return cservice.getCartDetails();
}
@GetMapping("/getcartbyid/{cartId}")
public Cart getcartbyid(@PathVariable int cartId) {
	return cservice.getCartByid(cartId);
}
@PutMapping("/updatecart")
public Cart updatecart(@RequestBody Cart cp) {
	return cservice.updatecart(cp);
}
@DeleteMapping("/deleteCart/{cartId}")
public void deleteCart(@PathVariable int cartId) {
	cservice.deletecart(cartId);
}
}