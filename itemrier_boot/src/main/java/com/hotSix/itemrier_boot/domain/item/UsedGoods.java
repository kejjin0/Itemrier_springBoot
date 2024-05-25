package com.hotSix.itemrier_boot.domain.item;

import java.time.LocalDateTime;
import java.util.Date;

import com.hotSix.itemrier_boot.domain.user.UserEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter 
@ToString
@Table(name = "USEDGOODS")
public class UsedGoods {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int itemId; // 상품 고유 번호
    
    private String itemName; // 상품명(제목)
    
    private String description; // 상품 설명
    
    private String condition; // 상품 상태
    
    private String contactType; // 연락수단
    
    private String status; // 거래 현황 
    
    @ManyToOne
    @JoinColumn(name="userId")
    private UserEntity seller; // 판매자
    
    @ManyToOne
    @JoinColumn(name = "catId")
    private Category category; // 카테고리
    
    @ManyToOne
    @JoinColumn(name = "userId2")    
    private UserEntity buyer; // 구매자
    
    private LocalDateTime registerDate; // 등록날짜
    
    private LocalDateTime transactionDate;	// 거래 날짜
    
    private int price; // 가격

    @Builder
	public UsedGoods(int itemId, String itemName, String description, String condition, String contactType,
			String status, UserEntity seller, Category category, int buyer, LocalDateTime registerDate,
			LocalDateTime transactionDate, int price) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.description = description;
		this.condition = condition;
		this.contactType = contactType;
		this.status = status;
		this.seller = seller;
		this.category = category;
		this.buyer = buyer;
		this.registerDate = registerDate;
		this.transactionDate = transactionDate;
		this.price = price;
	}	
}
