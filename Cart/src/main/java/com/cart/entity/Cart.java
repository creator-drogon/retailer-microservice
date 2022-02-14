package com.cart.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



@Entity
public class Cart {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
private int cartId;



@OneToMany(targetEntity=LineItem.class,cascade=CascadeType.ALL)
@JoinColumn(name="cartId",referencedColumnName="cartId")

List<LineItem> lineItems;



public int getCartId() {
	return cartId;
}



public void setCartId(int cartId) {
	this.cartId = cartId;
}



public List<LineItem> getLineItems() {
	return lineItems;
}



public void setLineItems(List<LineItem> lineItems) {
	this.lineItems = lineItems;
}

}
