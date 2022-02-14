package com.config.server.repository;

import com.config.server.entity.CustomerCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerCartRepo extends JpaRepository<CustomerCart, Integer> {

    @Query("FROM CustomerCart WHERE customerId= :customerId")
    CustomerCart getCartId(@Param("customerId") int customerId);
}
