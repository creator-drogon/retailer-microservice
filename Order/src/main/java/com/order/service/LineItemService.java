package com.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.entity.LineItem;
import com.order.exceptionhandling.DataNotFoundException;
import com.order.repository.LineItemRepository;

@Service
public class LineItemService {
	
	@Autowired
	LineItemRepository repo;
	
	public LineItem addLineItem(LineItem item){
		return repo.save(item);
	}
	
	public int deleteteLineItem(int id){
		int flag = 0;
		
		if(repo.findById(id).isPresent()){
			repo.deleteById(id);
			flag = 1;
		}
		
		else{
			throw new DataNotFoundException(id);
		}
		
		return flag;
	}
	
	public LineItem updateLineItem(int id, LineItem item){
		
		Optional<LineItem> foundItem = repo.findById(id);
		LineItem updatedItem = null;
		if(foundItem.isPresent()){
			updatedItem = repo.save(item);
		}
		
		else{
			throw new DataNotFoundException(id);
		}
		
		return updatedItem;
	}
	
	public LineItem searchLineItem(int id){
		LineItem foundItem = null;
		Optional<LineItem> item = repo.findById(id);

		if(item.isPresent()){
			foundItem = item.get();
		}
		
		else{
			throw new DataNotFoundException(id);
		}
		
		return foundItem;
	}
	
	public List<LineItem> getLineItems(int orderid){
		List<LineItem> items = repo.findAllLineItemsForOrder(orderid);
		return items;
	}
}
