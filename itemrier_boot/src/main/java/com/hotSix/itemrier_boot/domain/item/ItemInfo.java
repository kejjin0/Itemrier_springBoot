package com.hotSix.itemrier_boot.domain.item;

import com.hotSix.itemrier_boot.domain.category.Category;
import com.hotSix.itemrier_boot.domain.user.UserEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "ITEMINFO")
public abstract class ItemInfo {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int itemId; // 상품 고유 번호
	
	@Column(nullable = false)
	private String itemName; // 상품명(제목)
	
	@Column(nullable = false)
	private String description; // 상품 설명
	
	@Column(nullable = false)
	private int price; // 가격
	
	@Column(nullable = false)
	private String status; // 거래 현황
	
	@ManyToOne
    @JoinColumn(name="userId", nullable = false)
	private UserEntity seller; // 판매자
	
	@ManyToOne
    @JoinColumn(name="userId2", nullable = false)
	private UserEntity user; 
	
	@ManyToOne
    @JoinColumn(name = "catId", nullable = false)
	private Category category; // 카테고리
}
