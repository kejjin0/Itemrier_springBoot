package com.hotSix.itemrier_boot.domain.item;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

@Entity
@Setter @Getter @ToString
public class Bid {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int bidId; // 입찰 아이디
    private int amount; // 입찰 금액
    private Timestamp bidTime; // 입찰 시간
    private int itemId; // 입찰 상품
    private int userId; // 입찰한 유저아이디
    
    public Bid() {}

    @Builder
    public Bid(int bidId, int amount, Timestamp bidTime, int itemId, int userId) {
        super();
        this.bidId = bidId;
        this.amount = amount;
        this.bidTime = bidTime;
        this.itemId = itemId;
        this.userId = userId;
    }
}
