package com.hotSix.itemrier_boot.domain.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Embedded;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ORDERS")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	@Id
	private String orderId; // 주문 아이디

	@OneToMany(cascade = CascadeType.ALL) 
	@JoinColumn(name = "orderId")
	private List<OrderItem> orderItems;
	
	@Column(nullable = true)
	private String type; // 구매자 아이디

	@Column(nullable = false)
	private int buyerId; // 구매자 아이디

	@Embedded
	private BuyerInfo buyerInfo; // 구매자 정보(이름, 전화번호)

	@Embedded
	private DeliveryInfo deliveryInfo; // 배송 정보

	@Column(nullable = false)
	private String email; // 구매자 email

	@Column(nullable = false)
	private int price; // 주문 금액

	@Column(nullable = false)
	private int quantity; // 주문 수량

	@Column(nullable = false)
	private String pg; // 결제 시 pg사 코드값

	@Column(nullable = false)
	private String pay_method; // 결제 수단

	@Column(nullable = false)
	private LocalDateTime orderDate; // 결제 시간

	private int invoiceNumber; // 송장번호

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private OrderStatus status; // 결제 상태 (주문 완료 or 취소)
}
