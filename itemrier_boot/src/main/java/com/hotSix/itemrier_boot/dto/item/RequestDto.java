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
public class RequestDto {
	private int itemId;
	private String itemName;
	private String description;
	private String condition;
	private ItemStatus status;
	private LocalDateTime registerDate;
	private int price;
	private String catId;
	private Category category;
	private String contactType;
	private UserEntity seller;
	private String fileName;
	private String filePath;
	
	public UsedGoods toUsedGoods(RequestDto usedGoodsDto) {
		UsedGoods usedGoods = new UsedGoods();
		usedGoods.setItemId(usedGoodsDto.getItemId());
		usedGoods.setItemName(usedGoodsDto.getItemName());
		usedGoods.setDescription(usedGoodsDto.getDescription());
		usedGoods.setCondition(usedGoodsDto.getCondition());
		usedGoods.setStatus(usedGoodsDto.getStatus());
		usedGoods.setPrice(usedGoodsDto.getPrice());
		usedGoods.setCategory(usedGoodsDto.getCategory());
		usedGoods.setContactType(usedGoodsDto.getContactType());
		usedGoods.setSeller(usedGoodsDto.getSeller());
		usedGoods.setFileName(usedGoodsDto.getFileName());
		usedGoods.setFilePath(usedGoodsDto.getFilePath());
		return usedGoods;
	}
	
	public static RequestDto toUsedGoodsDto(UsedGoods usedGoods) {
		RequestDto dto = new RequestDto();
		dto.setItemId(usedGoods.getItemId());
		dto.setItemName(usedGoods.getItemName());
		dto.setStatus(usedGoods.getStatus());
		dto.setPrice(usedGoods.getPrice());
		dto.setFilePath(usedGoods.getFilePath());
		dto.setFileName(usedGoods.getFileName());
		return dto;
	}
}
