package com.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cart.entity.LineItem;


public interface LineItemRepository extends JpaRepository<LineItem,Integer>{
	
 LineItem findById(int id); 

}
