package com.hotSix.itemrier_boot.repository.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotSix.itemrier_boot.domain.order.Order;
import com.hotSix.itemrier_boot.domain.order.OrderStatus;

@Repository
public interface OrderRepository extends JpaRepository<Order, String>{
	// orderId 존재 여부 확인
	Boolean existsByOrderId(String orderId);
	
	// (구매자) 
	// 마이페이지 (구매) 공동 구매 or 경매 주문 내역
//	@Query("SELECT o FROM Order o JOIN o.orderItems i JOIN ItemInfo f ON i.itemId = f.itemId WHERE f.type = :type AND o.buyerId = :buyerId")
	List<Order> findOrderByBuyerIdAndType(int buyerId, String type);
		
	// 마이페이지에서 주문 내역 클릭 -> 구매 상세 내역(주문한 물품들 리스트, 주소, 사용자 정보 등)
	// 취소 확인 정보 전달, 결제 확인 창
	//	@Query("SELECT o FROM Order o JOIN o.OrderItem i WHERE o.orderId = :orderId")
	Order findOrderByOrderId(String orderId);	
	
	// 성함, 전화번호 변경
	// 배송지 변경
	// 현황 변경( 결제 완료 -> 주문 취소)
	// => save 사용
	
	
	// (판매자)
	// 상품 구매자 정보 확인 (총 구매자수, 구매자 정보)	// itemId가 Order에 없음
	@Query("SELECT count(i) FROM Order o JOIN o.orderItems i WHERE i.itemId = :itemId and o.status = :status")
	long countByItemIdAndStatus(@Param("itemId") int itemId, @Param("status") OrderStatus status);
	
	
	@Query(value = "SELECT o FROM Order o JOIN o.orderItems i WHERE i.itemId = :itemId and o.status = :status")
	List<Order> findOrderByItemIdAndStatus(@Param("itemId") int itemId, @Param("status") OrderStatus status);
	
	// 송장 번호 입력 및 수정 => save 사용
}
