package com.hotSix.itemrier_boot.domain.item;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
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
    
    private int buyerId; // 구매자 아이디
}
