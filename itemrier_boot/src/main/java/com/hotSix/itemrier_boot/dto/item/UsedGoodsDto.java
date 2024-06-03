package com.hotSix.itemrier_boot.dto.item;

import java.time.LocalDateTime;

import com.hotSix.itemrier_boot.domain.category.Category;
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
	private String description;
	private int price; // 가격
	private ItemStatus status;
	private LocalDateTime registerDate;
	private UserEntity seller;
	private UserEntity buyer;
	private Integer buyerId;
	private Category category;
	private String condition;
	private String contactType;
	private String image;
	
	public UsedGoods toUsedGoods(UsedGoodsDto usedGoodsDto) {
		UsedGoods uesdGoods = new UsedGoods();
		uesdGoods.setItemId(usedGoodsDto.getItemId());
		uesdGoods.setItemName(usedGoodsDto.getItemName());
		uesdGoods.setDescription(usedGoodsDto.getDescription());
		uesdGoods.setPrice(usedGoodsDto.getPrice());
		uesdGoods.setStatus(usedGoodsDto.getStatus());
		uesdGoods.setRegisterDate(usedGoodsDto.getRegisterDate());
		uesdGoods.setSeller(usedGoodsDto.getSeller());
		uesdGoods.setBuyer(usedGoodsDto.getBuyer());
		uesdGoods.setBuyerId(usedGoodsDto.getBuyerId());
		uesdGoods.setCategory(usedGoodsDto.getCategory());
		uesdGoods.setCondition(usedGoodsDto.getCondition());
		uesdGoods.setContactType(usedGoodsDto.getContactType());
		uesdGoods.setImage(usedGoodsDto.getImage());
		
		return uesdGoods;		
	}
}
