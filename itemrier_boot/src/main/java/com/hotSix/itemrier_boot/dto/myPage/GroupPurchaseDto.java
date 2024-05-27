package com.hotSix.itemrier_boot.dto.myPage;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
@Data
public class GroupPurchaseDto {
	private int itemId;
	private String itemName;
	private int price; // 가격
	private String status;
	private Long sellerId;
	private Long buyerId;

}
