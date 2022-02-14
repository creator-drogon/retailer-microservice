package com.config.server.repository;

import com.config.server.entity.CustomerCart;
import com.config.server.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface CustomerOrderRepo extends JpaRepository<CustomerOrder, Integer> {

    @Query("FROM CustomerOrder WHERE customerId= :customerId")
    Set<CustomerOrder> getOrders(@Param("customerId") int customerId);
}
