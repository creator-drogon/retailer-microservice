package com.cart.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LineItem {
@Id
private int productId;
private String productName;
private double productPrice;
private double quantity;
public double getQuantity() {
	return quantity;
}
public void setQuantity(double quantity) {
	this.quantity = quantity;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public double getProductPrice() {
	return productPrice;
}
public void setProductPrice(double productPrice) {
	this.productPrice = productPrice;
}

}
