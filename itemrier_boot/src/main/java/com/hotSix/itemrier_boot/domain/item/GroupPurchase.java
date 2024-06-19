package com.hotSix.itemrier_boot.domain.item;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.hotSix.itemrier_boot.dto.item.GroupPurchaseDto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter 
@ToString
@Table(name = "GROUPPURCHASE")
@DiscriminatorValue("groupPurchase")
@EntityListeners(AuditingEntityListener.class)
public class GroupPurchase extends ItemInfo {
    @Column(nullable = false)
    private int minQuantity; // 최소수량
    
    private int totalQuantity; // 구매한 수량 총합
    
    @Column(nullable = false)
    @CreatedDate                                        
    @DateTimeFormat(pattern = "yyyy-MM-dd/HH:mm:ss")
    private LocalDateTime startTime; // 시작시간(등록 날짜)
    
    @Column(nullable = false)
    private LocalDateTime endTime; // 종료시간
    
    private double discRate; // 할인율
    
    private Integer buyerId; // 구매자 아이디
    
    private String fileName; // 이미지 파일 이름
    
    private String filePath; // 이미지 파일 경로
    
    private Integer originalPrice; // 할인 전 가격
    
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
		groupPurchaseDto.setFileName(groupPurchase.getFileName());
		groupPurchaseDto.setFilePath(groupPurchase.getFilePath());
		groupPurchaseDto.setOriginalPrice(groupPurchase.getOriginalPrice());
		return groupPurchaseDto;
	}
  	
  	public void update(GroupPurchaseDto dto) {
  		this.setItemName(dto.getItemName());
  		this.setDescription(dto.getDescription());
  		this.setPrice(dto.getPrice());
  		this.setOriginalPrice(dto.getOriginalPrice());
  		this.setDiscRate(dto.getDiscRate());
  		this.setMinQuantity(dto.getMinQuantity());
  		this.setCategory(dto.getCategory());
  		this.setEndTime(dto.getEndTime());
  		this.setStatus(dto.getStatus());
  	}
}
