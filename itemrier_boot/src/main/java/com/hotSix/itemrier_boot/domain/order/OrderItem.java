package com.hotSix.itemrier_boot.domain.order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import jakarta.persistence.IdClass;
import com.hotSix.itemrier_boot.domain.item.ItemInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="ORDERITEM")
@IdClass(OrderItemPK.class)	
@Getter 
@Setter
@SuppressWarnings("serial")
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
	@Id
	private int lineNum;
	
	@Id
	private String orderId;
	
	@Column(nullable = false)
	private int itemId;
	
	@ManyToOne
	@JoinColumn(name="itemId", insertable=false, updatable=false)
	private ItemInfo itemInfo;
	
	@Column(nullable = false)
	private int orderPrice;
	
	@Column(nullable = false)
	private int amount;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private OrderStatus status; // 결제 상태 (주문 완료 or 취소)
}
