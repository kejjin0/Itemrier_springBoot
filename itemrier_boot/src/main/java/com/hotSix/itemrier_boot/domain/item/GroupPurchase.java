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
public class GroupPurchase extends ItemInfo{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GROUP_SEQ")
    private int itemId; // 상품 고유 번호
    // private int quantity; // 상품 수량
    private int minQuantity; // 최소수량
    private int totalQuantity; // 최대수량
    // private Date startTime; // 시작시간
    private Date endTime; // 종료시간
    private double discRate; // 할인율
    @Column(name = "userId")
    private int sellerId; // 글 등록자 아이디
    @Column(name = "userId2")
    private int buyerId; // 구매자 아이디
    private int catId; // 카테고리 아이디
    
    public GroupPurchase() {}

    @Builder
    public GroupPurchase(int itemId, int minQuantity, int totalQuantity, Date endTime, double discRate, int sellerId,
            int buyerId, int catId) {
        super();
        this.itemId = itemId;
        this.minQuantity = minQuantity;
        this.totalQuantity = totalQuantity;
        this.endTime = endTime;
        this.discRate = discRate;
        this.sellerId = sellerId;
        this.buyerId = buyerId;
        this.catId = catId;
    }
}
