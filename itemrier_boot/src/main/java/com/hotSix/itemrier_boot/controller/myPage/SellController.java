package com.hotSix.itemrier_boot.controller.myPage;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotSix.itemrier_boot.dto.myPage.UsedGoodsDto;
import com.hotSix.itemrier_boot.service.myPage.SellService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/mypage")
public class SellController {
	
	private final SellService sellService;

	//중고거래 판매,예약 상품내역
	@GetMapping("/usedGoodsTransaction/inProgress")
	public List<UsedGoodsDto> getUsedGoodsInProgress(Model model) {
		
		List<UsedGoodsDto> userGoodsList = sellService.getUsedGoodsInProgress(202);
		model.addAttribute(userGoodsList);
		
		return userGoodsList;
	}
	
}
