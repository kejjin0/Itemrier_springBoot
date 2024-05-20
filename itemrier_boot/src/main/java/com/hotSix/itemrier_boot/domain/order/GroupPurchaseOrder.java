package com.hotSix.itemrier_boot.domain.order;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.hotSix.itemrier_boot.domain.lineItem.LineItem;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name="GroupPurchaseOrder")
@Getter @ToString
public class GroupPurchaseOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;	// 주문 아이디
	private LineItem lineItem;
	private BuyerInfo buyerInfo;
	private String email;	// 구매자 email
	private DeliveryInfo deliveryInfo;
	private int price;		// 주문 금액
	private int quantity;	// 주문 수량
	private String pg;	// 결제 시 pg사 코드값
	private String pay_method;	// 결제 수단
	private Date orderDate;		// 결제 시간
	private int invoiceNumber;	// 송장번호
	private String status;	// 결제 상태 (주문 or 취소)
	
	
	@Builder
	public GroupPurchaseOrder(int orderId, LineItem lineItem, BuyerInfo buyerInfo, String email, DeliveryInfo deliveryInfo,
			int price, int quantity, String pg, String pay_method, Date orderDate, int invoiceNumber, String status) {
		super();
		this.orderId = orderId;
		this.lineItem = lineItem;
		this.buyerInfo = buyerInfo;
		this.email = email;
		this.deliveryInfo = deliveryInfo;
		this.price = price;
		this.quantity = quantity;
		this.pg = pg;
		this.pay_method = pay_method;
		this.orderDate = orderDate;
		this.invoiceNumber = invoiceNumber;
		this.status = status;
	}
}
