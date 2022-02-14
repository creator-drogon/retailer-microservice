package com.order.controller;

//import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.entity.Cart;
import com.order.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/")
	public ResponseEntity<Cart> addOrder(@RequestBody Cart order){
		return new ResponseEntity<>(orderService.saveOrder(order),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable("id") int orderid){
		return new ResponseEntity<>(orderService.deleteOrder(orderid),HttpStatus.FOUND);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateOrder(@PathVariable("id") int orderid, @RequestBody Cart order){
		return new ResponseEntity<>(orderService.updateOrder(orderid,order),HttpStatus.FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> searchOrder(@PathVariable("id") int orderid){
		return new ResponseEntity<>(orderService.searchOrder(orderid),HttpStatus.FOUND);
	}
}
