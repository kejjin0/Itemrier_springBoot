package com.hotSix.itemrier_boot.domain.item;

import java.time.LocalDateTime;

import com.hotSix.itemrier_boot.dto.myPage.UsedGoodsDto;

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
    private LocalDateTime registerDate; // 등록날짜
    
    private LocalDateTime transactionDate;	// 거래 날짜
    
    private String image; // 이미지 파일 이름
    
    private int buyerId;
  
  	public UsedGoodsDto toUsedGoodsDto(UsedGoods uesdGoods) {
		  UsedGoodsDto usedGoodsDto = new UsedGoodsDto();
		  usedGoodsDto.setItemId(uesdGoods.getItemId());
      usedGoodsDto.setItemName(uesdGoods.getItemName());
		  usedGoodsDto.setPrice(uesdGoods.getPrice());
      usedGoodsDto.setStatus(uesdGoods.getStatus());
      usedGoodsDto.setRegisterDate(uesdGoods.getRegisterDate());
      usedGoodsDto.setSeller(uesdGoods.getSeller());
      usedGoodsDto.setBuyer(uesdGoods.getBuyer());
      return usedGoodsDto;
	}
}