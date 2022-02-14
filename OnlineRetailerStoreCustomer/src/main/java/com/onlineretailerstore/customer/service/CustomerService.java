package com.onlineretailerstore.customer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineretailerstore.customer.models.Customer;
import com.onlineretailerstore.customer.repository.CustomerBillingAddressRepository;
import com.onlineretailerstore.customer.repository.CustomerRepository;
import com.onlineretailerstore.customer.repository.CustomerShippingAddressRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerBillingAddressRepository billRepo;
	@Autowired
	CustomerShippingAddressRepository shipRepo;
	
	public Customer addCustomer(Customer customer)
	{
		return customerRepository.save(customer);
	}
	public boolean deleteCustomer(int id)
	{
		customerRepository.deleteById(id);
		
		return customerRepository.findById(id).isEmpty();
	}
	public Customer searchById(int id)
	{
		Optional<Customer> cus=customerRepository.findById(id);
		return cus.get();
	}
	public Customer updateCustomer(Customer customer,int id)
	{

		customer.setCustomerId(id);
		return customerRepository.save(customer);
		

	}
}
