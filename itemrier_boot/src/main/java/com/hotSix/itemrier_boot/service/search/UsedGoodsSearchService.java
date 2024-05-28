//package com.hotSix.itemrier_boot.service.search;
//
//import com.hotSix.itemrier_boot.domain.item.ItemInfo;
//import com.hotSix.itemrier_boot.domain.item.UsedGoods;
//import com.hotSix.itemrier_boot.repository.item.ItemRepository;
//import com.hotSix.itemrier_boot.repository.user.UserRepository;
//
//import lombok.RequiredArgsConstructor;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class UsedGoodsSearchService {
//
//    
//    private final ItemRepository itemRepository;
//
////    public List<UsedGoods> searchUsedGoods(String keyword) {
////        return itemRepository.findByItemNameContainingIgnoreCase(keyword).stream()
////                .filter(item -> item instanceof UsedGoods)
////                .map(item -> (UsedGoods) item)
////                .collect(Collectors.toList());
////    }
//}
