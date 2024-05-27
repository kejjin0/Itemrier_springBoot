//미완 ; 공동구매 검색
package com.example.demo.controller;

import com.example.demo.domain.GroupPurchase;
import com.example.demo.service.GroupPurchaseSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupPurchaseSearchController {

    @Autowired
    private GroupPurchaseSearchService gpSearchService;

    @GetMapping("/groupPurchase/search")
    public List<GroupPurchase> searchGroupPurchases(@RequestParam("searchWord") String searchWord) {
        return gpSearchService.searchGroupPurchases(searchWord);
    }
}
