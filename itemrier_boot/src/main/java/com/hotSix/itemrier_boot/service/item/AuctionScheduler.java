package com.hotSix.itemrier_boot.service.item;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hotSix.itemrier_boot.domain.item.Auction;
import com.hotSix.itemrier_boot.domain.item.Bid;
import com.hotSix.itemrier_boot.domain.item.ItemStatus;
import com.hotSix.itemrier_boot.repository.item.AuctionRepository;
import com.hotSix.itemrier_boot.repository.item.BidRepository;

@Component
public class AuctionScheduler {
	@Autowired
	private AuctionRepository auctionRepository;
	
	@Autowired
	private BidRepository bidRepository;
	
	@Scheduled(fixedRate = 60000)
	public void updateAuctionStatus() {		
		LocalDateTime now = LocalDateTime.now();
		List<Auction> auctions = auctionRepository.findAllByEndTimeBeforeAndStatus(now, ItemStatus.Available);
		
		for (Auction auction: auctions) {
			auction.setStatus(ItemStatus.Complete);
			List<Bid> highestBids = bidRepository.findHighestBids(auction);
			if (!highestBids.isEmpty()) {
			    Bid highestBid = highestBids.get(0); // 가장 큰 입찰을 가져옴
			    auction.setWinner(highestBid.getUser().getUserId());
			} 
			if (auction.getWinner() == null) {
				auction.setStatus(ItemStatus.Cancel);
			}
			auctionRepository.save(auction);
		}
	}
}
