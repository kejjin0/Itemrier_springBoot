package com.hotSix.itemrier_boot.service.item;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.hotSix.itemrier_boot.domain.item.Auction;
import com.hotSix.itemrier_boot.domain.item.Bid;
import com.hotSix.itemrier_boot.domain.user.UserEntity;
import com.hotSix.itemrier_boot.dto.item.BidDto;
import com.hotSix.itemrier_boot.repository.item.AuctionRepository;
import com.hotSix.itemrier_boot.repository.item.BidRepository;
import com.hotSix.itemrier_boot.repository.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BidService {
	private final UserRepository userRepository;
	
	private final BidRepository bidRepository;

	private final AuctionRepository auctionRepository;
	
	// 입찰 등록
	public void save(BidDto dto, int sellerId) {
		UserEntity user = userRepository.findByUserId(sellerId);
		dto.setUser(user);
		
		Bid bid = dto.toEntity(dto);
		bidRepository.save(bid);
		
		updateCurrentBid(dto.getItem(), dto.getAmount());
	}
	
	public Bid findBidByAuctionAndUser(Auction auction, UserEntity user) {
		return bidRepository.findByItemAndUser(auction, user);
	}
	
	// 입찰 업데이트
	public void updateBid(Bid bid, BidDto bidDto) {
		bid.setAmount(bidDto.getAmount());
		bid.setBidTime(LocalDateTime.now());
		bidRepository.save(bid);
		
		// 경매 상품 currentBid 변경
		Auction auction = bid.getItem();
		updateCurrentBid(auction, bidDto.getAmount());		
	}
	
	// 경매 상품 최고가(currentBid) 변경
	public void updateCurrentBid(Auction auction, int amount) {
		if (auction.getCurrentBid() < amount) {
			auction.setCurrentBid(amount);
			auctionRepository.save(auction);
		}
	}
	
	// 입찰 취소
	public void delete(int bidId) {
		// 낙찰자(winner) 변경 필요
		Bid bid = bidRepository.getReferenceById(bidId);
		Auction auction = bid.getItem();
		
		bidRepository.deleteById(bidId);
		
		List<Bid> remainingBids = bidRepository.findByItemOrderByAmountDescBidTimeAsc(auction);
		if(remainingBids.isEmpty()) {
			auction.setWinner(null);
		} else {
			Bid newBid = remainingBids.get(0);
			auction.setWinner(newBid.getUser().getUserId());
			auction.setCurrentBid(newBid.getAmount());
		}
		auctionRepository.save(auction);
	}
	
	// 유효성 체크
	public Map<String, String> validateHandling(BindingResult result) {
		Map<String, String> validatorResult = new HashMap<>();
		for (FieldError error: result.getFieldErrors()) {
			String validKeyName = String.format("valid_%s", error.getField());
			validatorResult.put(validKeyName, error.getDefaultMessage());
		}
		return validatorResult;
	}
}
