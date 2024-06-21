package com.hotSix.itemrier_boot.service.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotSix.itemrier_boot.domain.order.BuyerInfo;
import com.hotSix.itemrier_boot.domain.order.DeliveryInfo;
import com.hotSix.itemrier_boot.domain.order.Order;
import com.hotSix.itemrier_boot.domain.order.OrderItem;
import com.hotSix.itemrier_boot.domain.order.OrderStatus;
import com.hotSix.itemrier_boot.repository.order.OrderRepository;

@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepository;
	
	// 주문
	public void insertOrder(Order order) {
		orderRepository.save(order);
	}
	
	// orderId 존재하는지 확인
	public Boolean existsByOrderId(String orderId) {
		Boolean check = orderRepository.existsByOrderId(orderId);
		return check;
	}
	
	// order 가져오기
	public Order getOrder(String orderId) {
		Order order = orderRepository.findOrderByOrderId(orderId);
		return order;
	}
	
	// 구매자 정보 확인
	public long getOrderCount(int itemId, OrderStatus status) {
		long count = orderRepository.countByItemIdAndStatus(itemId, status);
		return count;
	}
	
	public List<Order> getOrderList(int itemId, OrderStatus status){
		List<Order> orders = orderRepository.findOrderByItemIdAndStatus(itemId, status);
		return orders;
	}
	
	// (구매자)
	// 마이페이지 (구매) 공동 구매 주문 내역
	public List<Order> getOrders(int buyerId, String type){
		List<Order> orders = orderRepository.findOrderByBuyerIdAndType(buyerId, type);
		return orders;
	}
	
	
	// 성함, 전화번호 변경
	public void modifyBuyerInfo(String orderId, BuyerInfo buyerInfo) {
		Order order = orderRepository.findOrderByOrderId(orderId);
		order.setBuyerInfo(buyerInfo);
		orderRepository.save(order);
	}
	
	// 배송지 변경
	public void modifyDeliveryInfo(String orderId, DeliveryInfo deliveryInfo) {
		Order order = orderRepository.findOrderByOrderId(orderId);
		order.setDeliveryInfo(deliveryInfo);
		orderRepository.save(order);
	}
	
	// 현황 변경
	public void modifyStatus(String orderId) {
		Order order = orderRepository.findOrderByOrderId(orderId);
		order.setStatus(OrderStatus.Cancel);
		List<OrderItem> items = order.getOrderItems();
		for(OrderItem i : items) {
			i.setStatus(OrderStatus.Cancel);
		}
		
		orderRepository.save(order);
	}

}
