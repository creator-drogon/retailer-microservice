package com.onlineretailstore.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onlineretailstore.inventory.entity.Inventory;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    @Modifying
    @Query("UPDATE Inventory set quantity= :quantity WHERE productId= :productId")
    int updateInventory(@Param("quantity") int quantity, @Param("productId") int productId);
}
