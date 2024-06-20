package com.hotSix.itemrier_boot.domain.item;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
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
@EntityListeners(AuditingEntityListener.class)
public class UsedGoods extends ItemInfo {
    @Column(nullable = false)
    private String condition; // 상품 상태
    
    @Column(nullable = false)
    private String contactType; // 연락수단
   
    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd/HH:mm:ss")
    private LocalDateTime registerDate; // 등록날짜
    
    private LocalDateTime transactionDate;	// 거래 날짜
    
    private String fileName; // 이미지 파일 이름
    
    private String filePath; // 이미지 파일 경로
    
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
  		usedGoods.setItemId(usedGoodsDto.getItemId());
  		usedGoods.setItemName(usedGoodsDto.getItemName());
  		usedGoods.setDescription(usedGoodsDto.getDescription());
		usedGoods.setPrice(usedGoodsDto.getPrice());
		usedGoods.setStatus(usedGoodsDto.getStatus());
		usedGoods.setCategory(usedGoodsDto.getCategory());
		usedGoods.setCondition(usedGoodsDto.getCondition());
		usedGoods.setContactType(usedGoodsDto.getContactType());
		usedGoods.setSeller(usedGoodsDto.getSeller());
		usedGoods.setRegisterDate(usedGoodsDto.getRegisterDate());
		usedGoods.setFileName(usedGoodsDto.getFileName());
		usedGoods.setFilePath(usedGoodsDto.getFilePath());
		return usedGoods;
  	}
  	
  	public static UsedGoods toUpdateEntityWithBuyerId(UsedGoodsDto usedGoodsDto) {
  		UsedGoods usedGoods = new UsedGoods();
  		usedGoods.setItemId(usedGoodsDto.getItemId());
  		usedGoods.setItemName(usedGoodsDto.getItemName());
  		usedGoods.setDescription(usedGoodsDto.getDescription());
		usedGoods.setPrice(usedGoodsDto.getPrice());
		usedGoods.setStatus(usedGoodsDto.getStatus());
		usedGoods.setCategory(usedGoodsDto.getCategory());
		usedGoods.setCondition(usedGoodsDto.getCondition());
		usedGoods.setContactType(usedGoodsDto.getContactType());
		usedGoods.setSeller(usedGoodsDto.getSeller());
		usedGoods.setRegisterDate(usedGoodsDto.getRegisterDate());
		usedGoods.setFileName(usedGoodsDto.getFileName());
		usedGoods.setFilePath(usedGoodsDto.getFilePath());
		usedGoods.setBuyerId(usedGoodsDto.getBuyerId());
		return usedGoods;
  	}
}