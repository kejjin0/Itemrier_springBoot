package com.hotSix.itemrier_boot.repository.item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotSix.itemrier_boot.domain.item.ItemInfo;
import com.hotSix.itemrier_boot.domain.item.UsedGoods;
import com.hotSix.itemrier_boot.domain.user.UserEntity;

public interface ItemRepository extends JpaRepository<ItemInfo, Integer> {

	List<ItemInfo> findBySeller(UserEntity seller);
	
	List<UsedGoods> findByItemIdIn(List<ItemInfo> itemInfo);
}
