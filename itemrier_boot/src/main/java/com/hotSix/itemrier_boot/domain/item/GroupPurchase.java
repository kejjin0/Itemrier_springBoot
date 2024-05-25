package com.hotSix.itemrier_boot.domain.item;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter 
@ToString
@SequenceGenerator(
		name = "GP_SEQ_GENERATOR",
		sequenceName = "GROUP_SEQ")
@Table(name = "GROUPPURCHASE")
public class GroupPurchase{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GP_SEQ_GENERATOR")
    private int itemId; // 상품 고유 번호
    
    // private int quantity; // 상품 수량
    
    private int minQuantity; // 최소수량
    
    private int totalQuantity; // 최대수량
    
    private LocalDateTime startTime; // 시작 시간(등록 날짜)
    
    private LocalDateTime endTime; // 종료시간
    
    private double discRate; // 할인율
    
    @ManyToOne
    @JoinColumn(name="userId")
    private int sellerId; // 판매자
    
    @Column(name = "userId2")
    private int buyerId; // 구매자 아이디
    
    @ManyToOne
    @JoinColumn(name = "catId")
    private Category catId; // 카테고리 아이디
    
    @Builder
	public GroupPurchase(int itemId, int minQuantity, int totalQuantity, LocalDateTime startTime, LocalDateTime endTime,
			double discRate, int sellerId, int buyerId, Category catId) {
		super();
		this.itemId = itemId;
		this.minQuantity = minQuantity;
		this.totalQuantity = totalQuantity;
		this.startTime = startTime;
		this.endTime = endTime;
		this.discRate = discRate;
		this.sellerId = sellerId;
		this.buyerId = buyerId;
		this.catId = catId;
	}    
}
