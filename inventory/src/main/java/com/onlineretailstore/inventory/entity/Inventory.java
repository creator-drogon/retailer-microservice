package com.onlineretailstore.inventory.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.Hibernate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "inventory")
@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@TableGenerator(name = "inventoryId", initialValue = 6, allocationSize = 1000)
	private int inventoryId;

	@Column(name = "productId", nullable = false)
	private int productId;

	@Column(name = "quantity", nullable = false)
	private int quantity;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		Inventory inventory = (Inventory) o;

		return Objects.equals(inventoryId, inventory.inventoryId);
	}

}
