package com.hotSix.itemrier_boot.service.item;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hotSix.itemrier_boot.domain.item.GroupPurchase;
import com.hotSix.itemrier_boot.domain.item.ItemStatus;
import com.hotSix.itemrier_boot.repository.item.GroupPurchaseRepository;

@Component
public class GroupPurchaseScheduler {
	@Autowired 
	private GroupPurchaseRepository groupPurchaseRepository;
	
	@Scheduled(fixedRate = 60000)
	public void updateGroupPurchaseStatus() {
		LocalDateTime now = LocalDateTime.now();
		List<GroupPurchase> groupPurchases = groupPurchaseRepository.findAllByEndTimeBeforeAndStatus(now, ItemStatus.Available);
		
		for (GroupPurchase gp: groupPurchases) {
			if (gp.getTotalQuantity() < gp.getMinQuantity()) { // 목표 수량 달성 실패
				gp.setStatus(ItemStatus.Cancel);
			} else { // 폭표 수량 달성 성공
				gp.setStatus(ItemStatus.Complete);
			}
			groupPurchaseRepository.save(gp);
		}
	}
}
