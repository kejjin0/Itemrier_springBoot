package com.hotSix.itemrier_boot.controller.item;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotSix.itemrier_boot.domain.item.Auction;
import com.hotSix.itemrier_boot.domain.item.Bid;
import com.hotSix.itemrier_boot.domain.user.UserEntity;
import com.hotSix.itemrier_boot.dto.item.BidDto;
import com.hotSix.itemrier_boot.repository.user.UserRepository;
import com.hotSix.itemrier_boot.service.item.BidService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/bid")
public class BidController {
	@Autowired
	private BidService bidService;
	
	@Autowired
	private UserRepository userRepository;
	
	// 입찰 등록
	@PostMapping("/create")
	public String save(@AuthenticationPrincipal UserDetails userDetail, @Valid BidDto bidDto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("bidDto", bidDto);
			
			Map<String, String> validatorResult = bidService.validateHandling(result);
			for (String key: validatorResult.keySet()) {
				model.addAttribute(key, validatorResult.get(key));
			}
			return "thymeleaf/item/auction/bidForm";
		}
		UserEntity user = userRepository.findByEmail(userDetail.getUsername());
		int userId = user.getUserId();
//		int userId = 2953; // Test 용
		
		Bid existingBid = bidService.findBidByAuctionAndUser(bidDto.getItem(), userRepository.getReferenceById(userId));
		if (existingBid != null) {
			bidService.updateBid(existingBid, bidDto);
		}
		else {
			bidService.save(bidDto, userId);
		}
		return "redirect:/bid/complete";
	}
	
	// 입찰 완료
	@GetMapping("/complete")
	public String bidComplete() {
		return "thymeleaf/item/auction/bidComplete";
	}
	
	// 입찰 취소(삭제)
	@GetMapping("/delete/{bidId}")
	public String delete(@PathVariable int bidId) {
		bidService.delete(bidId);
		return "redirect:/auction/list";
	}
}
