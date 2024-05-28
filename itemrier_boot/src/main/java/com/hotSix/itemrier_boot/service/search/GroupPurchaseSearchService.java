//package com.hotSix.itemrier_boot.service.search;
//
//import com.hotSix.itemrier_boot.domain.item.GroupPurchase;
//import com.hotSix.itemrier_boot.domain.item.ItemInfo;
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
//public class GroupPurchaseSearchService {
//
//    @Autowired
//    private final ItemRepository itemRepository;
//
////    public List<GroupPurchase> searchGroupPurchases(String keyword) {
////        return itemRepository.findByItemNameContainingIgnoreCase(keyword).stream()
////                .filter(item -> item instanceof GroupPurchase)
////                .map(item -> (GroupPurchase) item)
////                .collect(Collectors.toList());
////    }
//}
