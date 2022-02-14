package com.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cart.dto.LineItems;
import com.cart.entity.LineItem;
import com.cart.service.LineItemService;


@RestController
public class LineItemController {
	
	@Autowired
	private LineItemService lineItemService;

	@PostMapping("/addLineItem")
	public void addLineItem(@RequestBody  LineItem lineItem) {
		lineItemService.createLineItem(lineItem);
	}

	@GetMapping("/searchLineItem/{ProductId}")
	public LineItem searchLineItem(@PathVariable int ProductId) {
		return lineItemService.searchLineItem(ProductId);
	}
	
	@GetMapping("/getlineItems")
	public List<LineItem> findAllLineItem()
	{
			return lineItemService.findAllLineItems();
	}

	@DeleteMapping("/lineItem/{ProductId}")
	public void deleteLineItem(@PathVariable int ProductId) {
		lineItemService.deleteLineItem(ProductId);
	}
	
	@PutMapping("/UpdatelineItem")
	public LineItem updateLineItem(@RequestBody LineItem lt ) {
		
		return lineItemService.updateLineItem(lt);
		
	}
	
}
