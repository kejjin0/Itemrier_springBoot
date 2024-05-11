package com.hotSix.itemrier_boot.domain.usedGoodsTransaction;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.hotSix.itemrier_boot.domain.lineItem.LineItem;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name="UsedGoodsTransaction")
@Getter @ToString
public class UsedGoodsTransaction {
	private LineItem lineItem;
	private String price;	// 상품 금액
	private int sellerId;	// 판매자 아이디
	private int buyerId;	// 구매자 아이디
	private Date transactionDate;// 거래 날짜
	
	@Builder
	public UsedGoodsTransaction(LineItem lineItem, String price, int sellerId, int buyerId, Date transactionDate) {
		super();
		this.lineItem = lineItem;
		this.price = price;
		this.sellerId = sellerId;
		this.buyerId = buyerId;
		this.transactionDate = transactionDate;
	}
}
