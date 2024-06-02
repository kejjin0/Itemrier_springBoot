package com.hotSix.itemrier_boot.domain.item;

import java.time.LocalDateTime;

import com.hotSix.itemrier_boot.dto.item.GroupPurchaseDto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter 
@ToString
@Table(name = "GROUPPURCHASE")
@DiscriminatorValue("groupPurchase")
public class GroupPurchase extends ItemInfo {
    @Column(nullable = false)
    private int minQuantity; // 최소수량
    
    @Column(nullable = false)
    private int totalQuantity; // 최대수량(총수량)
    
    @Column(nullable = false)
    private LocalDateTime startTime; // 시작시간(등록 날짜)
    
    @Column(nullable = false)
    private LocalDateTime endTime; // 종료시간
    
    private double discRate; // 할인율
    
    private Integer buyerId; // 구매자 아이디
    
    private String image; // 이미지 파일 이름
    
  	public GroupPurchaseDto toGroupPurchaseDto(GroupPurchase groupPurchase) {
  		GroupPurchaseDto groupPurchaseDto = new GroupPurchaseDto();
  		groupPurchaseDto.setItemId(groupPurchase.getItemId());
  		groupPurchaseDto.setItemName(groupPurchase.getItemName());
  		groupPurchaseDto.setDescription(groupPurchase.getDescription());;
  		groupPurchaseDto.setPrice(groupPurchase.getPrice());
  		groupPurchaseDto.setStatus(groupPurchase.getStatus());
  		groupPurchaseDto.setSeller(groupPurchase.getSeller());
		groupPurchaseDto.setBuyer(groupPurchase.getBuyer());
		groupPurchaseDto.setCategory(groupPurchase.getCategory());;
		groupPurchaseDto.setMinQuantity(groupPurchase.getMinQuantity());;
		groupPurchaseDto.setTotalQuantity(groupPurchase.getTotalQuantity());;
		groupPurchaseDto.setStartTime(groupPurchase.getStartTime());;
		groupPurchaseDto.setEndTime(groupPurchase.getEndTime());
		groupPurchaseDto.setDiscRate(groupPurchase.getDiscRate());
		groupPurchaseDto.setBuyerId(groupPurchase.getBuyerId());
		groupPurchaseDto.setImage(groupPurchase.getImage());
		
		return groupPurchaseDto;
	}
}
