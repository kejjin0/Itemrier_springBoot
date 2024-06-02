package com.hotSix.itemrier_boot.dto.item;


import java.time.LocalDateTime;

import com.hotSix.itemrier_boot.domain.category.Category;
import com.hotSix.itemrier_boot.domain.item.GroupPurchase;
import com.hotSix.itemrier_boot.domain.item.ItemStatus;
import com.hotSix.itemrier_boot.domain.user.UserEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
@Data
public class GroupPurchaseDto {
	private int itemId;
	private String itemName;
	private String description; // 상품 설명
	private int price; // 가격
	private ItemStatus status; // 거래 현황(판매 중, 판매 완료)
	private UserEntity seller;
	private UserEntity buyer; 
	private Category category;
	private int minQuantity; // 최소수량
	private int totalQuantity; // 최대수량(총수량)
	private LocalDateTime startTime; // 시작시간(등록 날짜)
	private LocalDateTime endTime;
	private double discRate; // 할인율
	private Integer buyerId; // 구매자 아이디
	private String image; // 이미지 파일 이름
	
	public GroupPurchase toGroupPurchase(GroupPurchaseDto groupPurchaseDto) {
		GroupPurchase groupPurchase = new GroupPurchase();
		groupPurchase.setItemId(groupPurchaseDto.getItemId());
		groupPurchase.setItemName(groupPurchaseDto.getItemName());
		groupPurchase.setDescription(groupPurchaseDto.getDescription());;
		groupPurchase.setPrice(groupPurchaseDto.getPrice());
		groupPurchase.setStatus(groupPurchaseDto.getStatus());
		groupPurchase.setSeller(groupPurchaseDto.getSeller());
		groupPurchase.setBuyer(groupPurchaseDto.getBuyer());
		groupPurchase.setCategory(groupPurchaseDto.getCategory());;
		groupPurchase.setMinQuantity(groupPurchaseDto.getMinQuantity());;
		groupPurchase.setTotalQuantity(groupPurchaseDto.getTotalQuantity());;
		groupPurchase.setStartTime(groupPurchaseDto.getStartTime());;
		groupPurchase.setEndTime(groupPurchaseDto.getEndTime());
		groupPurchase.setDiscRate(groupPurchaseDto.getDiscRate());
		groupPurchase.setBuyerId(groupPurchaseDto.getBuyerId());
		groupPurchase.setImage(groupPurchaseDto.getImage());
		
		return groupPurchase;		
	}
	
}
