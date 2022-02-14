package com.order.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class LineItem implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	
	int productId;
	
	
	String productName;
	
	
	int quantity;
	
	
	double price;
	
	public LineItem(int productId, String productName, int quantity, double price) {
		super();
		this.id = id;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}


	
}
