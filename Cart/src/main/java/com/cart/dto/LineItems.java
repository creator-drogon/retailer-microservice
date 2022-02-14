package com.cart.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.cart.entity.LineItem;

public class LineItems {
	
	@Autowired
	private LineItem lt;
	
	public LineItem getLineItem() {
		return lt;
	}
	
	public void setLineItem(LineItem lt) {
		this.lt=lt;
	}

}
