package com.hotSix.itemrier_boot.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotSix.itemrier_boot.domain.order.OrderItem;
import com.hotSix.itemrier_boot.domain.order.OrderItemPK;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
