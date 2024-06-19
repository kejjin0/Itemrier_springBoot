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
	
	private String strStatus; // status추가
	
	private LocalDateTime registerDate;
	private long userId;
	private UserEntity seller;
	private UserEntity buyer;
	private Integer buyerId;
	private Category category;
	private String condition;
	private String contactType;
	private String fileName;
	private String filePath;

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
		return uesdGoods;		
	}
	
	public static UsedGoodsDto toUsedGoodsDto(UsedGoods usedGoods) {
		UsedGoodsDto ugDto = new UsedGoodsDto();
		ugDto.setItemId(usedGoods.getItemId());
		ugDto.setItemName(usedGoods.getItemName());
		ugDto.setDescription(usedGoods.getDescription());
		ugDto.setPrice(usedGoods.getPrice());
		ugDto.setStatus(usedGoods.getStatus());
		ugDto.setRegisterDate(usedGoods.getRegisterDate());
		ugDto.setUserId(usedGoods.getSeller().getUserId());
		ugDto.setSeller(usedGoods.getSeller());
		ugDto.setCategory(usedGoods.getCategory());
		ugDto.setCondition(usedGoods.getCondition());
		ugDto.setContactType(usedGoods.getContactType());
		ugDto.setFileName(usedGoods.getFileName());
		ugDto.setFilePath(usedGoods.getFilePath());
		return ugDto;
	}
}
