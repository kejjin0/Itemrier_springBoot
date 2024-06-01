package com.hotSix.itemrier_boot.repository.item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotSix.itemrier_boot.domain.item.ItemInfo;
import com.hotSix.itemrier_boot.domain.item.ItemStatus;
import com.hotSix.itemrier_boot.domain.item.UsedGoods;
import com.hotSix.itemrier_boot.domain.user.UserEntity;

public interface ItemRepository extends JpaRepository<ItemInfo, Integer> {

	List<UsedGoods> findBySellerAndStatus(UserEntity seller, ItemStatus status);
}
