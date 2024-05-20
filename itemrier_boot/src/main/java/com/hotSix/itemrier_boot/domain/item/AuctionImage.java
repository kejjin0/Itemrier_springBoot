package com.hotSix.itemrier_boot.domain.item;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter @ToString
public class AuctionImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int auctionId;
    private String imageUrl;
    
    public AuctionImage() {}

    @Builder
    public AuctionImage(Long id, int auctionId, String imageUrl) {
        super();
        this.id = id;
        this.auctionId = auctionId;
        this.imageUrl = imageUrl;
    }
}
