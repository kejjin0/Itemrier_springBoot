package com.hotSix.itemrier_boot.service;

import com.hotSix.itemrier_boot.domain.item.ItemInfo;
import com.hotSix.itemrier_boot.domain.item.UsedGoods;
import com.hotSix.itemrier_boot.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsedGoodsSearchService {

    @Autowired
    private ItemRepository itemRepository;

    public List<UsedGoods> searchUsedGoods(String keyword) {
        return itemRepository.findByItemNameContainingIgnoreCase(keyword).stream()
                .filter(item -> item instanceof UsedGoods)
                .map(item -> (UsedGoods) item)
                .collect(Collectors.toList());
    }
}
