package com.order.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Cart implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int orderId;
	
	
	LocalDate orderDate;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="order_id")
	List<LineItem> lineItems = new ArrayList<>();

	public void addItem(LineItem item){
		this.lineItems.add(item);
	}

	public Cart(int id, LocalDate orderDate, List<LineItem> items) {
		super();
		this.orderId = id;
		this.orderDate = orderDate;
		this.lineItems = items;
	}

	
	
}
