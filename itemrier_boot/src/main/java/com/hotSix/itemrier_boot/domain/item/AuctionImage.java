package com.hotSix.itemrier_boot.domain.item;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
