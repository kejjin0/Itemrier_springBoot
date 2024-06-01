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
public class SellService {
	private final ItemRepository itemRepository;
	private final UserRepository userRepository;
	
	public List<UsedGoodsDto> getUsedGoodsInProgress(int sellerId) {  //판매 중 or 예약 중인 내역
		List<UsedGoods> usedGoods;

		UserEntity seller = userRepository.findByUserId(sellerId);
		usedGoods = itemRepository.findBySellerAndStatus(seller, ItemStatus.Available);

        List<UsedGoodsDto> UsedGoodsDtoList = new ArrayList<>();
        for (UsedGoods usedGood : usedGoods) {
        	UsedGoodsDto postSearchDto = usedGood.toUsedGoodsDto(usedGood);
        	UsedGoodsDtoList.add(postSearchDto);
        }
        return UsedGoodsDtoList;
	}
}
