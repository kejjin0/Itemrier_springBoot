package com.hotSix.itemrier_boot.domain.item;

import java.time.LocalDateTime;

import com.hotSix.itemrier_boot.domain.user.UserEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter 
@ToString
@Table(name = "BID")
public class Bid {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int bidId; // 입찰 아이디
    
    @Column(nullable = false)
    private int amount; // 입찰 금액
    
    @Column(nullable = false)
    private LocalDateTime bidTime; // 입찰 시간
    
    @ManyToOne
    @JoinColumn(name = "itemId", nullable = false)
    private Auction item; // 입찰 상품
    
    @ManyToOne
    @JoinColumn(name="user_Id", nullable = false)
    private UserEntity user; // 입찰한 사용자
    
    private int winner; // 낙찰자
}
