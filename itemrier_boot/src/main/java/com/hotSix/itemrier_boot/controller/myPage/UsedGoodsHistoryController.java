package com.hotSix.itemrier_boot.controller.myPage;

import java.util.List;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotSix.itemrier_boot.domain.user.UserEntity;
import com.hotSix.itemrier_boot.dto.item.UsedGoodsDto;
import com.hotSix.itemrier_boot.repository.user.UserRepository;
import com.hotSix.itemrier_boot.service.myPage.UsedGoodsHistoryService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/myPage")
public class UsedGoodsHistoryController {
	
	private final UsedGoodsHistoryService usedGoodsService;
	private final UserRepository userRepository;
	
	//중고거래 판매,예약 상품내역
	@GetMapping("/usedGoodsTransaction/inProgress")
	public String getUsedGoodsInProgress(@AuthenticationPrincipal UserDetails userDetail, Model model) {
		UserEntity user = userRepository.findByEmail(userDetail.getUsername()); 
		int userId = user.getUserId(); //로그인한 계정의 PK값
		Boolean status = true;
		
		List<UsedGoodsDto> userGoodsList = usedGoodsService.getUsedGoodsStatusSearch(userId, status);
		model.addAttribute("userGoodsList", userGoodsList);
		for (int i = 0; i < userGoodsList.size(); i++) {
			System.out.println(userGoodsList.get(i));
		}
		return "myPage/usedGoods/usedGoodsInProgress";
	}
	
	//중고거래 판매완료된 상품내역
	@GetMapping("/usedGoodsTransaction/ended")
	public String getUsedGoodsEnded(@AuthenticationPrincipal UserDetails userDetail, Model model) {
		UserEntity user = userRepository.findByEmail(userDetail.getUsername()); 
		int userId = user.getUserId(); //로그인한 계정의 PK값
		Boolean status = false;
		
		List<UsedGoodsDto> userGoodsList = usedGoodsService.getUsedGoodsStatusSearch(userId, status);
		System.out.println("usedGoods" + userGoodsList);
		model.addAttribute(userGoodsList);
		
		return "myPage/usedGoods/usedGoodsEnded";
	}
	
	//구매내역 조회
	@GetMapping("/usedGoodsTransactionHistory")
	public String getUsedGoodsBuyHistory(@AuthenticationPrincipal UserDetails userDetail, Model model) {
		UserEntity user = userRepository.findByEmail(userDetail.getUsername()); 
		int userId = user.getUserId(); //로그인한 계정의 PK값
		
		List<UsedGoodsDto> userGoodsList = usedGoodsService.getUsedGoodsBuyHistory(userId);
		System.out.println("usedGoods" + userGoodsList);
		model.addAttribute(userGoodsList);
		
		return "myPage/usedGoods/purchasedUsedGoods";
	}
}
