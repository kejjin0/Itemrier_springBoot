package com.hotSix.itemrier_boot.dto.item;

import java.time.LocalDateTime;

import com.hotSix.itemrier_boot.domain.item.Auction;
import com.hotSix.itemrier_boot.domain.item.Bid;
import com.hotSix.itemrier_boot.domain.user.UserEntity;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
@Data
public class BidDto {
	private int bidId;
	
	@PositiveOrZero(message = "입찰 가격은 0 이상의 값이어야 합니다.")
    private Integer amount;
	
	private LocalDateTime bidTime;
	
	private Auction item;
	
	private UserEntity user;
	
	private int winner;
	
	public Bid toEntity(BidDto dto) {
		Bid bid = new Bid();
		bid.setBidId(dto.getBidId());
		bid.setAmount(dto.getAmount());
		bid.setBidTime(dto.getBidTime());
		bid.setItem(dto.getItem());
		bid.setUser(dto.getUser());
		return bid;
	}
}
