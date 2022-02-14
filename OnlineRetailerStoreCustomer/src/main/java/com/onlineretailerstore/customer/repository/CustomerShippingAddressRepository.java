package com.onlineretailerstore.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineretailerstore.customer.models.CustomerShippingAddress;

public interface CustomerShippingAddressRepository extends JpaRepository<CustomerShippingAddress, Integer> {

}
