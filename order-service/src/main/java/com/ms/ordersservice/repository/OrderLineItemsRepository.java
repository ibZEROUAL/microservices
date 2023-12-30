package com.ms.ordersservice.repository;

import com.ms.ordersservice.model.OrderLineItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderLineItemsRepository extends JpaRepository<OrderLineItems,Long> {

    @Query(value = "select * from t_order_line_items where order_id = :order_id",nativeQuery = true)
    List<OrderLineItems> getOrderLineItemsByOrderId(@Param("order_id") Long orderId);
    
    @Transactional
    @Query(value = """
     update t_order_line_items t set t.order_id = :newId where t.order_id = :oldId
    """,nativeQuery = true)
    @Modifying
    void updateOrderLineItemsByOrderId(@Param("oldId") Long oldOrderId,@Param("newId") Long newOrderId);

}
