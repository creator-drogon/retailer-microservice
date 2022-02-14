package com.order.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.entity.Cart;
import com.order.exceptionhandling.DataNotFoundException;
import com.order.repository.LineItemRepository;
import com.order.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository repo;
	
	@Autowired
	LineItemRepository itemsRepo;
	
	public Cart saveOrder(Cart order) {

		Cart cart = repo.save(order);
		return cart;
	}

	public int deleteOrder(int orderid) {
		
		int flag = 0;
		
		if(repo.findById(orderid).isPresent()){
			repo.deleteById(orderid);
			flag = 1;
		}
		
		else{
			throw new DataNotFoundException(orderid);
		}
		
		return flag;
	}

	public Cart updateOrder(int orderid, Cart order) {
		
		Optional<Cart> foundOrder1 = repo.findById(orderid);
		Cart updatedOrder = null;
		if(foundOrder1.isPresent()){
			updatedOrder = repo.save(order);
		}
		
		else{
			throw new DataNotFoundException(orderid);
		}
		
		return updatedOrder;
	}

	public Cart searchOrder(int orderid) {
		
		Cart foundOrder = null;
		Optional<Cart> order = repo.findById(orderid);

		if(order.isPresent()){
			foundOrder = order.get();
			foundOrder.setLineItems(itemsRepo.findAllLineItemsForOrder(orderid));
		}
		
		else{
			throw new DataNotFoundException(orderid);
		}
		
		return foundOrder;
	}

}
