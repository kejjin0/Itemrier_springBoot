package com.hotSix.itemrier_boot.service.myPage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hotSix.itemrier_boot.domain.item.GroupPurchase;
import com.hotSix.itemrier_boot.domain.item.ItemStatus;
import com.hotSix.itemrier_boot.domain.user.UserEntity;
import com.hotSix.itemrier_boot.dto.myPage.GroupPurchaseDto;
import com.hotSix.itemrier_boot.repository.item.GroupPurchaseRepository;
import com.hotSix.itemrier_boot.repository.user.UserRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class GroupPurchaseService {
	private final GroupPurchaseRepository groupPurchaseRepository;
	private final UserRepository userRepository;
	
	public List<GroupPurchaseDto> getGroupPurchaseStatusSearch(int sellerId, Boolean status) {  // 공동 거래 판매 중 or 예약 중/판매완료된 내역 조회
		List<GroupPurchase> groupPurchases;

		UserEntity seller = userRepository.findByUserId(sellerId);
		
		if (status == true) {
			groupPurchases = groupPurchaseRepository.findBySellerAndStatus(seller, ItemStatus.Available);
			System.out.println("판매중" + groupPurchases);
		}
		else {
			groupPurchases = groupPurchaseRepository.findBySellerAndStatus(seller, ItemStatus.Complete);
			System.out.println("판매완료" + groupPurchases);
		}
		
        List<GroupPurchaseDto> groupPurchaseDtoList = new ArrayList<>();
        for (GroupPurchase groupPurchase : groupPurchases) {
        	GroupPurchaseDto groupPurchaseDto = groupPurchase.toGroupPurchaseDto(groupPurchase);
        	groupPurchaseDtoList.add(groupPurchaseDto);
        }
        
        return groupPurchaseDtoList;
	}
	
}
