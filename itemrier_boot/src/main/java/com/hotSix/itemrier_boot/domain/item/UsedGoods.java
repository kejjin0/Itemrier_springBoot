package com.hotSix.itemrier_boot.domain.item;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.hotSix.itemrier_boot.dto.item.UsedGoodsDto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter 
@Setter
@ToString
@Table(name = "USEDGOODS")
@DiscriminatorValue("usedGoods")
public class UsedGoods extends ItemInfo {
    @Column(nullable = false)
    private String condition; // 상품 상태
    
    @Column(nullable = false)
    private String contactType; // 연락수단
   
    @Column(nullable = false)
    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd/HH:mm:ss")
    private LocalDateTime registerDate; // 등록날짜
    
    private LocalDateTime transactionDate;	// 거래 날짜
    
    private String image; // 이미지 파일 이름
    
    private Integer buyerId;
  
  	public UsedGoodsDto toUsedGoodsDto(UsedGoods uesdGoods) {
  		UsedGoodsDto usedGoodsDto = new UsedGoodsDto();
		usedGoodsDto.setItemId(uesdGoods.getItemId());
		usedGoodsDto.setItemName(uesdGoods.getItemName());
		usedGoodsDto.setPrice(uesdGoods.getPrice());
		usedGoodsDto.setStatus(uesdGoods.getStatus());
		usedGoodsDto.setRegisterDate(uesdGoods.getRegisterDate());
		usedGoodsDto.setSeller(uesdGoods.getSeller());
		usedGoodsDto.setBuyer(uesdGoods.getBuyer());
		usedGoodsDto.setBuyerId(uesdGoods.getBuyerId());
		return usedGoodsDto;
	}
  	
  	public static UsedGoods toUpdateEntity(UsedGoodsDto usedGoodsDto) {
  		UsedGoods usedGoods = new UsedGoods();
  		usedGoods.setItemName(usedGoodsDto.getItemName());
  		usedGoods.setDescription(usedGoodsDto.getDescription());
		usedGoods.setPrice(usedGoodsDto.getPrice());
		usedGoods.setCategory(usedGoodsDto.getCategory());
		usedGoods.setCondition(usedGoodsDto.getCondition());
		usedGoods.setContactType(usedGoodsDto.getContactType());
		usedGoods.setImage(usedGoodsDto.getImage());
		return usedGoods;
  	}
}