package com.cart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.entity.LineItem;
import com.cart.repository.LineItemRepository;
import com.cart.dto.LineItems;



@Service
public class LineItemService {

	@Autowired
	private LineItemRepository ltRepository;
	
	public void createLineItem(LineItem lineItem) {
		ltRepository.save(lineItem);
	}
	public LineItem searchLineItem(int ProductId) {
		return ltRepository.findById(ProductId);
	}
	public void deleteLineItem(int ProductId) {
		ltRepository.deleteById(ProductId);
	}
	
	public LineItem updateLineItem(LineItem request) {
		return ltRepository.save(request);
	}
	public List<LineItem> findAllLineItems() {
		
		List<LineItem> lineItem = new ArrayList<LineItem>(); 
		ltRepository.findAll().forEach(lineItem1 ->lineItem.add(lineItem1));  
		return lineItem;
	}

}
