package com.hotSix.itemrier_boot.domain.item;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter 
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
    
    private int buyerId; // 구매자 아이디
    
    private String fileName; // 이미지 파일 이름
    
    private String filePath; // 이미지 파일 경로
}