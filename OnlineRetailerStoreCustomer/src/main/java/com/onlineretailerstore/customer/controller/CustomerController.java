package com.onlineretailerstore.customer.controller;

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

import com.onlineretailerstore.customer.models.Customer;
import com.onlineretailerstore.customer.models.CustomerBillingAddress;
import com.onlineretailerstore.customer.repository.CustomerRepository;
import com.onlineretailerstore.customer.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	@Autowired
	CustomerService service;
	

	@PostMapping(value = "/create")
	public ResponseEntity<Integer> addCustomer(@RequestBody Customer customer) {
		Customer cust= service.addCustomer(customer);
		return new ResponseEntity<Integer>(cust.getCustomerId(), HttpStatus.CREATED);

	}
	@PostMapping(value="{id}/billingaddress/add")
	public ResponseEntity<Customer> addBilling(@RequestBody CustomerBillingAddress customer)
	{    
		return null;
	}
	@PostMapping(value="{id}/shippingaddress/add")
	public ResponseEntity<Customer> addShipping(@RequestBody CustomerBillingAddress customer)
	{    
		return null;
	}
	@DeleteMapping(value = "/{id}/delete")
	public ResponseEntity<Boolean> deleteCustomer(@PathVariable int id) {
		return new ResponseEntity<Boolean>(service.deleteCustomer(id),HttpStatus.OK);
	}

	@PutMapping(value = "{id}/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer,@PathVariable int id) {
		
			return new ResponseEntity<Customer>(service.updateCustomer(customer, id),HttpStatus.OK);
		
	
	}

	@GetMapping(value = "{id}/search")
	public ResponseEntity<Customer> getCustomer(@PathVariable int id) {
		return new ResponseEntity<Customer>(service.searchById(id),HttpStatus.OK);
	}

}
