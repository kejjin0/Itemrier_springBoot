package com.hotSix.itemrier_boot.domain.item;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter @ToString
public class Auction extends ItemInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUCTION_SEQ")
    private int itemId; // 상품 고유번호
    private String condition; // 상품 상태
    private String contactType; // 연락 수단
    private int startPrice; // 시작가
    private int currentBid; // 현재 최고가
    private Date startTime; // 시작시간
    private Date endTime; // 종료시간
    private int winner; // 낙찰자 유저 아이디
    @Column(name = "userId")
    private int sellerId; // 글 등록자 아이디
    private int buyerId; // 구매자 아이디
    private int catId; // 카테고리 아이디
    
    public Auction() {}

    @Builder
    public Auction(int itemId, String condition, String contactType, int startPrice, int currentBid, Date startTime,
            Date endTime, int winner, int sellerId, int buyerId, int catId) {
        super();
        this.itemId = itemId;
        this.condition = condition;
        this.contactType = contactType;
        this.startPrice = startPrice;
        this.currentBid = currentBid;
        this.startTime = startTime;
        this.endTime = endTime;
        this.winner = winner;
        this.sellerId = sellerId;
        this.buyerId = buyerId;
        this.catId = catId;
    }  
}
