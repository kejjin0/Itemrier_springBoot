package com.hotSix.itemrier_boot.domain.item;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter @ToString
public class UsedGoods extends ItemInfo{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int itemId; // 상품 고유 번호
    private String condition; // 상품 상태
    private String contactType; // 연락수단
    private Date registerDate; // 등록날짜
    @Column(name = "usedId")
    private int sellerId; // 글 등록자 아이디
    @Column(name = "usedId2")
    private int buyerId; // 구매자 아이디
    private int catId; // 카테고리 아이디
    
    public UsedGoods() {}

    @Builder
    public UsedGoods(int itemId, String condition, String contactType, Date registerDate, int sellerId, int buyerId,
            int catId) {
        super();
        this.itemId = itemId;
        this.condition = condition;
        this.contactType = contactType;
        this.registerDate = registerDate;
        this.sellerId = sellerId;
        this.buyerId = buyerId;
        this.catId = catId;
    }
}
