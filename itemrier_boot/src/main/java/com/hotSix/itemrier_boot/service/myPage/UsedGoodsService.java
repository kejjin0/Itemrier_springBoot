package com.hotSix.itemrier_boot.service.myPage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hotSix.itemrier_boot.domain.item.ItemInfo;
import com.hotSix.itemrier_boot.domain.item.UsedGoods;
import com.hotSix.itemrier_boot.domain.user.UserEntity;
import com.hotSix.itemrier_boot.dto.myPage.UsedGoodsDto;
import com.hotSix.itemrier_boot.repository.item.ItemRepository;
import com.hotSix.itemrier_boot.repository.user.UserRepository;
import com.hotSix.itemrier_boot.domain.item.ItemStatus;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsedGoodsService {
	private final ItemRepository itemRepository;
	private final UserRepository userRepository;
	
	public List<UsedGoodsDto> getUsedGoodsStatusSearch(int sellerId, Boolean status) {  // 중고 거래 판매 중 or 예약 중인 내역
		List<UsedGoods> usedGoods;

		UserEntity seller = userRepository.findByUserId(sellerId);
		
		if (status == true) {
			usedGoods = itemRepository.findBySellerAndStatus(seller, ItemStatus.Available);
			System.out.println("판매중" + usedGoods);
		}
		else {
			usedGoods = itemRepository.findBySellerAndStatus(seller, ItemStatus.Complete);
			System.out.println("판매완료" + usedGoods);
		}
		
        List<UsedGoodsDto> UsedGoodsDtoList = new ArrayList<>();
        for (UsedGoods usedGood : usedGoods) {
        	UsedGoodsDto postSearchDto = usedGood.toUsedGoodsDto(usedGood);
        	UsedGoodsDtoList.add(postSearchDto);
        }
        
        return UsedGoodsDtoList;
	}

}
