package com.hotSix.itemrier_boot.domain.lineItem;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class LineItem {
	private int itemId;
	// 대표 img 1개 추가
	private String itemName;
	private String sellerId;
	
	public LineItem(int itemId, String itemName) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
	}
		
}