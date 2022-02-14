package com.onlineretailerstore.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineretailerstore.customer.models.CustomerBillingAddress;

public interface CustomerBillingAddressRepository extends JpaRepository<CustomerBillingAddress, Integer>{

}
