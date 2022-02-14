package com.cart.dto;
import com.cart.entity.*;
import org.springframework.beans.factory.annotation.Autowired;

public class cartProduct {
@Autowired
private Cart cart;

public Cart getCart() {
	return cart;
}

public void setCart(Cart cart) {
	this.cart = cart;
}

}
