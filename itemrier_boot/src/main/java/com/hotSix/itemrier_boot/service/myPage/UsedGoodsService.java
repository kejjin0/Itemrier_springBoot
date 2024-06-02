package com.hotSix.itemrier_boot.service.myPage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hotSix.itemrier_boot.domain.item.UsedGoods;
import com.hotSix.itemrier_boot.domain.user.UserEntity;
import com.hotSix.itemrier_boot.dto.myPage.UsedGoodsDto;
import com.hotSix.itemrier_boot.repository.item.UsedGoodsRepository;
import com.hotSix.itemrier_boot.repository.user.UserRepository;
import com.hotSix.itemrier_boot.domain.item.ItemStatus;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsedGoodsService {
	private final UsedGoodsRepository usedGoodsRepository;
	private final UserRepository userRepository;
	
	public List<UsedGoodsDto> getUsedGoodsStatusSearch(int sellerId, Boolean status) {  // 중고 거래 판매 중 or 예약 중/판매완료된 내역 조회
		List<UsedGoods> usedGoods;

		UserEntity seller = userRepository.findByUserId(sellerId);
		
		if (status == true) {
			usedGoods = usedGoodsRepository.findBySellerAndStatus(seller, ItemStatus.Available);
			System.out.println("판매중" + usedGoods);
		}
		else {
			usedGoods = usedGoodsRepository.findBySellerAndStatus(seller, ItemStatus.Complete);
			System.out.println("판매완료" + usedGoods);
		}
		
        List<UsedGoodsDto> usedGoodsDtoList = new ArrayList<>();
        for (UsedGoods usedGood : usedGoods) {
        	UsedGoodsDto usedGoodsDto = usedGood.toUsedGoodsDto(usedGood);
        	usedGoodsDtoList.add(usedGoodsDto);
        }
        
        return usedGoodsDtoList;
	}
	
	public List<UsedGoodsDto> getUsedGoodsBuyHistory(int buyerId) {
		List<UsedGoods> usedGoods;

		usedGoods = usedGoodsRepository.findByBuyerId(buyerId);
		System.out.println("구매내역조회" + usedGoods);
		
        List<UsedGoodsDto> usedGoodsDtoList = new ArrayList<>();
        for (UsedGoods usedGood : usedGoods) {
        	UsedGoodsDto usedGoodsDto = usedGood.toUsedGoodsDto(usedGood);
        	usedGoodsDtoList.add(usedGoodsDto);
        }
        
        return usedGoodsDtoList;
	}

}
