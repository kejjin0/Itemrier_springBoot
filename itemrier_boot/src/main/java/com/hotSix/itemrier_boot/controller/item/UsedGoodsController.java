package com.hotSix.itemrier_boot.controller;

import com.hotSix.itemrier_boot.domain.item.UsedGoods;
import com.hotSix.itemrier_boot.service.UsedGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usedGoods")
public class UsedGoodsController {

    @Autowired
    private UsedGoodsService usedGoodsService;

    @GetMapping("/search")
    public List<UsedGoods> searchUsedGoods(@RequestParam("keyword") String keyword) {
        return usedGoodsService.searchUsedGoods(keyword);
    }
}
