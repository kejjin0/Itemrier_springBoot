package com.hotSix.itemrier_boot.controller.myPage;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotSix.itemrier_boot.dto.myPage.UsedGoodsDto;
import com.hotSix.itemrier_boot.service.myPage.UsedGoodsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/mypage")
public class UsedGoodsController {
	
	private final UsedGoodsService usedGoodsService;

	//중고거래 판매,예약 상품내역
	@GetMapping("/usedGoodsTransaction/inProgress")
	public List<UsedGoodsDto> getUsedGoodsInProgress(Model model) {
		Boolean status = true;
		List<UsedGoodsDto> userGoodsList = usedGoodsService.getUsedGoodsStatusSearch(202, status);
		System.out.println("usedGoods" + userGoodsList);
		model.addAttribute(userGoodsList);
		
		return userGoodsList;
	}
	
	//중고거래 판매완료된 상품내역
	@GetMapping("/usedGoodsTransaction/ended")
	public List<UsedGoodsDto> getUsedGoodsEnded(Model model) {
		Boolean status = false;
		List<UsedGoodsDto> userGoodsList = usedGoodsService.getUsedGoodsStatusSearch(202, status);
		System.out.println("usedGoods" + userGoodsList);
		model.addAttribute(userGoodsList);
		
		return userGoodsList;
	}
	
	
	@GetMapping("/usedGoodsTransactionHistory")
	public List<UsedGoodsDto> getUsedGoodsBuyHistory(Model model) {
		List<UsedGoodsDto> userGoodsList = usedGoodsService.getUsedGoodsBuyHistory(952);
		System.out.println("usedGoods" + userGoodsList);
		model.addAttribute(userGoodsList);
		
		return userGoodsList;
	}
}
