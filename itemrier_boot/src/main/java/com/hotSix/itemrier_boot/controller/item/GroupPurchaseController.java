package com.hotSix.itemrier_boot.controller.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hotSix.itemrier_boot.domain.category.Category;
import com.hotSix.itemrier_boot.domain.item.GroupPurchase;
import com.hotSix.itemrier_boot.domain.user.UserEntity;
import com.hotSix.itemrier_boot.dto.item.GroupPurchaseDto;
import com.hotSix.itemrier_boot.dto.item.RequestDto;
import com.hotSix.itemrier_boot.repository.item.CategoryRepository;
import com.hotSix.itemrier_boot.repository.user.UserRepository;
import com.hotSix.itemrier_boot.service.item.GroupPurchaseService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/groupPurchase")
public class GroupPurchaseController {

	@Autowired 
	private GroupPurchaseService groupPurchaseService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	// 공동구매 상품 등록 폼
	@GetMapping("/create")
	public String saveForm(Model model) {
		model.addAttribute("gpDto", new GroupPurchaseDto());
		return "thymeleaf/item/groupPurchase/createForm";
	}

	// 공동구매 상품 등록
	@PostMapping("/create")
	public String save(@AuthenticationPrincipal UserDetails userDetail, @Valid GroupPurchaseDto groupPurchaseDto, BindingResult result, Model model, MultipartFile file) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("gpDto", groupPurchaseDto);

			Map<String, String> validatorResult = groupPurchaseService.validateHandling(result);
			for (String key: validatorResult.keySet()) {
				model.addAttribute(key, validatorResult.get(key));
			}
			return "thymeleaf/item/groupPurchase/createForm";
		}
		// 로그인한 사용자
		UserEntity user = userRepository.findByEmail(userDetail.getUsername()); 
		int sellerId = user.getUserId(); 

		groupPurchaseService.save(groupPurchaseDto, sellerId, file);
		return "redirect:list";
	}

	// 공동구매 상품 수정 폼
	@GetMapping("/update/{itemId}")
	public String updateForm(@PathVariable int itemId, Model model) {
		GroupPurchaseDto gpDto = groupPurchaseService.findById(itemId);
		List<Category> category = categoryRepository.findAll();
		model.addAttribute("groupPurchase", gpDto);
		model.addAttribute("category", category);
		return "thymeleaf/item/groupPurchase/updateForm";
	}

	// 공동구매 상품 수정
	@PostMapping("/update")
	public String update(@ModelAttribute GroupPurchaseDto gpDto, Model model) {
		GroupPurchaseDto updateGroupPurchase = groupPurchaseService.update(gpDto);
		model.addAttribute("groupPurchase", updateGroupPurchase);
		return "redirect:view/" + updateGroupPurchase.getItemId();
	}

	// 공동구매 상품 삭제
	@GetMapping("/delete/{itemId}")
	public String delete(@PathVariable int itemId) throws Exception {
		groupPurchaseService.delete(itemId);
		return "redirect:/groupPurchase/list";
	}

	// 최소 수량 달성

	// 공동구매 상품 목록
	@GetMapping("/list")
	public String findAll(Model model) {
		List<GroupPurchaseDto> gpList = groupPurchaseService.findAll();
		List<List<GroupPurchaseDto>> gpDtoList = chunkList(gpList, 3);
		model.addAttribute("gpDtoList", gpDtoList);
		return "thymeleaf/item/groupPurchase/list";
	}

	// 리스트를 3개씩 묶음
	private List<List<GroupPurchaseDto>> chunkList(List<GroupPurchaseDto> list, int chunkSize) {
	    List<List<GroupPurchaseDto>> groupPurchaseList = new ArrayList<>();
	    for (int i = 0; i < list.size(); i += chunkSize) {
	    	groupPurchaseList.add(list.subList(i, Math.min(i + chunkSize, list.size())));
	    }
	    return groupPurchaseList;
	}
	
	// 공동구매 상품 상세보기
	@GetMapping("/view/{itemId}")
	public String findById(@PathVariable int itemId, Model model, @AuthenticationPrincipal UserDetails userDetail) {
		GroupPurchaseDto gpDto = groupPurchaseService.findById(itemId);
		model.addAttribute("groupPurchase", gpDto);

		UserEntity user = userRepository.findByEmail(userDetail.getUsername());
		int sellerId = user.getUserId();
		model.addAttribute("loginUserId", sellerId);
		
		 // 추천 상품 추가
        List<GroupPurchaseDto> recommendations = groupPurchaseService.recommend(gpDto.getCategory().getCatId(), itemId);
        model.addAttribute("recommendedItems", recommendations);
        
		return "thymeleaf/item/groupPurchase/view";
	}

	//검색한 상품만
	@GetMapping("/search")
	public String searchGroupPurchase(@RequestParam("query") String query, Model model) {
		List<GroupPurchaseDto> searchResults = groupPurchaseService.searchGroupPurchase(query);
		model.addAttribute("gpDtoList", searchResults);
		return "thymeleaf/item/groupPurchase/list";
	}
}
