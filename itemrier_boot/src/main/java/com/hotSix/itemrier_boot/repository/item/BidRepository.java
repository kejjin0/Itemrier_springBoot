package com.hotSix.itemrier_boot.repository.item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hotSix.itemrier_boot.domain.item.Auction;
import com.hotSix.itemrier_boot.domain.item.Bid;
import com.hotSix.itemrier_boot.domain.user.UserEntity;

public interface BidRepository extends JpaRepository<Bid, Integer> {
	// 한 경매 상품에 대한 여러 입찰 목록 - 금액이 큰 상품 -> 먼저 등록한 순으로
	List<Bid> findByItemOrderByAmountDescBidTimeAsc(Auction item); 
	
	// 사용자가 이미 경매에 참여한 이력이 있는지 확인
	Bid findByItemAndUser(Auction item, UserEntity user);
	
	// 가장 큰 입찰 금액
	@Query("SELECT b FROM Bid b WHERE b.item = :item ORDER BY b.amount DESC, b.bidTime ASC")
	List<Bid> findHighestBids(@Param("item") Auction item);
}
