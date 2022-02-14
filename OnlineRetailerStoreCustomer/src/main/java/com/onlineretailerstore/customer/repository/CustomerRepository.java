package com.onlineretailerstore.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineretailerstore.customer.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
