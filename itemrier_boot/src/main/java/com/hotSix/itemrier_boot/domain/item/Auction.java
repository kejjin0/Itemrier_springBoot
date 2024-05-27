package com.hotSix.itemrier_boot.domain.item;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter 
@ToString
@Table(name = "AUCTION")
public class Auction extends ItemInfo {
    @Column(nullable = false)
    private String condition; // 상품 상태
    
    @Column(nullable = false)
    private String contactType; // 연락 수단
    
    @Column(nullable = false)
    private int startPrice; // 시작가
    
    private int currentBid; // 현재 최고가
    
    @Column(nullable = false)
    private LocalDateTime startTime; // 시작시간(등록 날짜)
    
    @Column(nullable = false)
    private LocalDateTime endTime; // 종료시간
        
    private int buyerId; // 구매자 아이디
    
    private String fileName; // 이미지 파일 이름
    
    private String filePath; // 이미지 파일 경로
}
