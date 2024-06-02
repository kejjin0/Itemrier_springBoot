package com.hotSix.itemrier_boot.controller.myPage;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotSix.itemrier_boot.dto.myPage.GroupPurchaseDto;
import com.hotSix.itemrier_boot.service.myPage.GroupPurchaseHistoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/myPage")
public class GroupPurchaseHistoryController {
	
	private final GroupPurchaseHistoryService groupPurchaseService;
	
	//공동구매 판매 중인 상품내역
	@GetMapping("/groupPurchase/inProgress")
	public List<GroupPurchaseDto> getUsedGoodsInProgress(Model model) {
		Boolean status = true;
		List<GroupPurchaseDto> groupPurchaseList = groupPurchaseService.getGroupPurchaseStatusSearch(401, status);
		System.out.println("groupPurchase" + groupPurchaseList);
		model.addAttribute(groupPurchaseList);
		
		return groupPurchaseList;
	}
	
	//공동구매 판매완료된 상품내역
	@GetMapping("/groupPurchase/ended")
	public List<GroupPurchaseDto> getUsedGoodsEnded(Model model) {
		Boolean status = false;
		List<GroupPurchaseDto> groupPurchaseList = groupPurchaseService.getGroupPurchaseStatusSearch(401, status);
		System.out.println("groupPurchase" + groupPurchaseList);
		model.addAttribute(groupPurchaseList);
		
		return groupPurchaseList;
	}
	
}
