package com.hotSix.itemrier_boot.domain.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class BuyerInfo {
	private int buyerId;	// 구매자 아이디
	private String buyerName;	// 구매자 이름
	private String phoneNum;	// 구매자 전화번호
	
	public BuyerInfo(int buyerId, String buyerName, String phoneNum) {
		super();
		this.buyerId = buyerId;
		this.buyerName = buyerName;
		this.phoneNum = phoneNum;
	}
}
