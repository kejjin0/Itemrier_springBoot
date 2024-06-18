package com.hotSix.itemrier_boot.domain.item;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.hotSix.itemrier_boot.domain.user.UserEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter 
@Setter
@ToString
@Table(name = "BID")
@EntityListeners(AuditingEntityListener.class)
public class Bid {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int bidId; // 입찰 아이디
    
    @Column(nullable = false)
    private int amount; // 입찰 금액
    
    @CreatedDate                                        
    @DateTimeFormat(pattern = "yyyy-MM-dd/HH:mm:ss")
    private LocalDateTime bidTime; // 입찰 시간
    
    @ManyToOne
    @JoinColumn(name = "item_Id", nullable = false)
    private Auction item; // 입찰 상품
    
    @ManyToOne
    @JoinColumn(name="user_Id", nullable = false)
    private UserEntity user; // 입찰한 사용자
    
    private int winner; // 낙찰자
}
