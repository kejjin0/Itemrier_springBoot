package com.hotSix.itemrier_boot.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotSix.itemrier_boot.domain.order.OrderItem;
import com.hotSix.itemrier_boot.domain.order.OrderItemPK;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{
	// 한 상품에 대해서 사람들이 구매한 개수 총합(TOTAL_QUANTITY 개수)
	@Query("SELECT COUNT(o) FROM OrderItem o WHERE o.itemId = :itemId")
	int countByItemId(int itemId);
}
