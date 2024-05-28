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

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SellService {
	private final ItemRepository itemRepository;
	private final UserRepository userRepository;
	
	public List<UsedGoodsDto> getUsedGoodsInProgress(Long sellerId) {
		List<ItemInfo> itemInfo;
		List<UsedGoods> usedGoods;
       
		UserEntity seller = userRepository.findByUserId(sellerId);
		itemInfo = itemRepository.findBySeller(seller);
        
		usedGoods = itemRepository.findByItemIdIn(itemInfo);
		
        List<UsedGoodsDto> UsedGoodsDtoList = new ArrayList<>();
        for (UsedGoods usedGood : usedGoods) {
        	UsedGoodsDto postSearchDto = usedGood.toUsedGoodsDto(usedGood);
        	UsedGoodsDtoList.add(postSearchDto);
        }
        return UsedGoodsDtoList;
	}
}
