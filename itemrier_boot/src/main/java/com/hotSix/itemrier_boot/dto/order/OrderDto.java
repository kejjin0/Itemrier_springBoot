package com.hotSix.itemrier_boot.dto.order;

import java.time.LocalDateTime;

import com.hotSix.itemrier_boot.domain.order.BuyerInfo;
import com.hotSix.itemrier_boot.domain.order.DeliveryInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
	private String orderId; // 주문 아이디
	private int buyerId; // 구매자 아이디
	private BuyerInfo buyerInfo; // 구매자 정보(이름, 전화번호)
	private DeliveryInfo deliveryInfo; // 배송 정보
	private String email; // 구매자 email
	private int price; // 주문 금액
	private int quantity; // 주문 수량
	private String pg; // 결제 시 pg사 코드값
	private String pay_method; // 결제 수단
	private LocalDateTime orderDate; // 결제 시간
	private int itemId;
	private String type;
}
