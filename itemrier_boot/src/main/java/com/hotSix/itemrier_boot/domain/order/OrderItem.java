package com.hotSix.itemrier_boot.domain.order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
import lombok.ToString;

@Entity
@Table(name="ORDERITEM")
@IdClass(OrderItemPK.class)	
@Getter 
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int lineNum;
	
	@Id
	private int orderId;
	
	@Column(nullable = false)
	private String itemId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="itemId")
	private ItemInfo itemInfo;
	
	@Column(nullable = false)
	private int orderPrice;
	
	@Column(nullable = false)
	private int amount;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private OrderStatus status; // 결제 상태 (주문 완료 or 취소)
}
