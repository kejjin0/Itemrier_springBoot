package com.hotSix.itemrier_boot.dto.myPage;

import java.time.LocalDateTime;

import com.hotSix.itemrier_boot.domain.item.ItemStatus;
import com.hotSix.itemrier_boot.domain.item.UsedGoods;
import com.hotSix.itemrier_boot.domain.user.UserEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
@Data
public class UsedGoodsDto {
	private int itemId;
	private String itemName;
	private int price; // 가격
	private ItemStatus status;
	private LocalDateTime registerDate;
	private UserEntity seller;
	private UserEntity buyer;
	private Integer buyerId;
	
	public UsedGoods toUsedGoods(UsedGoodsDto usedGoodsDto) {
		UsedGoods uesdGoods = new UsedGoods();
		uesdGoods.setItemId(usedGoodsDto.getItemId());
		uesdGoods.setItemName(usedGoodsDto.getItemName());
		uesdGoods.setPrice(usedGoodsDto.getPrice());
		uesdGoods.setStatus(usedGoodsDto.getStatus());
		uesdGoods.setRegisterDate(usedGoodsDto.getRegisterDate());
		uesdGoods.setSeller(usedGoodsDto.getSeller());
		uesdGoods.setBuyer(usedGoodsDto.getBuyer());
		uesdGoods.setBuyerId(usedGoodsDto.getBuyerId());
		
		return uesdGoods;		
	}
}
