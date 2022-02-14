package com.order.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.order.entity.LineItem;

@Repository
@Transactional
public interface LineItemRepository extends JpaRepository<LineItem, Integer> {
	
//	@Query("SELECT item FROM LineItem item WHERE item.orderid= :id")
//	List<LineItem> findAllLineItemsForOrder(@Param("id") int orderid);
	
	@Modifying
	@Query(value="SELECT * FROM LINE_ITEM WHERE order_id= :id",nativeQuery=true )
	List<LineItem> findAllLineItemsForOrder(@Param("id") int orderid);
	
}
