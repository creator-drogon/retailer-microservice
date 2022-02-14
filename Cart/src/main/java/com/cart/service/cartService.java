package com.cart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.dto.cartProduct;
import com.cart.entity.Cart;
import com.cart.repository.cartRepository;

@Service
public class cartService {
@Autowired
cartRepository crep;
public Cart addToCart(Cart cp) {
	Cart cart = crep.save(cp);
	return cart;
}
public List<Cart> getCartDetails(){
	List<Cart> list=new ArrayList<Cart>();
	crep.findAll().forEach(a->list.add(a));
	return list;
}
public Cart getCartByid(int id) {
	return crep.findById(id).get();
}
public Cart updatecart(Cart cp) {
	return crep.save(cp);
}
public void deletecart(int id) {
	crep.deleteById(id);
}
}
