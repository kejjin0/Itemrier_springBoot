package com.hotSix.itemrier_boot.controller.item;

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
import com.hotSix.itemrier_boot.domain.item.Bid;
import com.hotSix.itemrier_boot.domain.user.UserEntity;
import com.hotSix.itemrier_boot.dto.item.AuctionDto;
import com.hotSix.itemrier_boot.dto.item.BidDto;
import com.hotSix.itemrier_boot.repository.item.BidRepository;
import com.hotSix.itemrier_boot.repository.item.CategoryRepository;
import com.hotSix.itemrier_boot.repository.user.UserRepository;
import com.hotSix.itemrier_boot.service.item.AuctionService;
import com.hotSix.itemrier_boot.service.item.BidService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/auction")
public class AuctionController {
	
	@Autowired
	private AuctionService auctionService;

	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private BidRepository bidRepository;
		
	// 경매 상품 등록 폼
	@GetMapping("/create")
	public String saveForm(Model model) {
		List<Category> category = categoryRepository.findAll();
		model.addAttribute("auctionDto", new AuctionDto());
		model.addAttribute("category", category);
		return "thymeleaf/item/auction/createForm";
	}
	
	// 경매 상품 등록
	@PostMapping("/create")
	public String save(@AuthenticationPrincipal UserDetails userDetail, @Valid AuctionDto auctionDto, BindingResult result, Model model, MultipartFile file) throws Exception {
		if (result.hasErrors()) { // 이 부분 성공하면 updateForm에도 적용해주기
			model.addAttribute("auctionDto", auctionDto);
			
			Map<String, String> validatorResult = auctionService.validateHandling(result);
			for (String key: validatorResult.keySet()) {
				model.addAttribute(key, validatorResult.get(key));
			}
			return "thymeleaf/item/auction/createForm";
		}
		UserEntity user = userRepository.findByEmail(userDetail.getUsername()); 
		int sellerId = user.getUserId(); 
//		int sellerId = 2953; // Tets용
		auctionService.save(auctionDto, sellerId, file);
		return "redirect:list";
	}
	
	// 경매 상품 수정 폼
	@GetMapping("/update/{itemId}")
	public String updateForm(@PathVariable int itemId, Model model) {
		AuctionDto aucDto = auctionService.findById(itemId);
		List<Category> category = categoryRepository.findAll();
		model.addAttribute("auction", aucDto);
		model.addAttribute("category", category);
		return "thymeleaf/item/auction/updateForm";
	}
	
	// 경매 상품 수정
	@PostMapping("/update")
	public String update(@ModelAttribute AuctionDto auctionDto, Model model) {
		AuctionDto updateAuction = auctionService.update(auctionDto);
		model.addAttribute("auction", updateAuction);
		System.out.println("테스트 중: " + auctionDto.getStatus() + auctionDto.getItemName());
		return "redirect:view/" + updateAuction.getItemId();
	}
	
	// 경매 상품 삭제
	@GetMapping("/delete/{itemId}")
	public String delete(@PathVariable int itemId) throws Exception {
		auctionService.delete(itemId);
		return "redirect:/auction/list";
	}
	
	// 경매 상품 목록
	@GetMapping("/list")
	public String findAll(Model model) {
		List<AuctionDto> auctionDtoList = auctionService.findAll();
		model.addAttribute("auctionList", auctionDtoList);
		return "thymeleaf/item/auction/list";
	}
	
	// 경매 상품 상세보기(추가할 부분: 입찰 내용도 보여야 함)
	@GetMapping("/view/{itemId}")
	public String findById(@PathVariable int itemId, Model model, @AuthenticationPrincipal UserDetails userDetail) {
		AuctionDto auctionDto = auctionService.findById(itemId);
		model.addAttribute("auction", auctionDto);
		
		List<Bid> bids = bidRepository.findByItemOrderByAmountDescBidTimeAsc(auctionDto.toEntity(auctionDto));
		model.addAttribute("bids", bids);
		
		if (auctionDto.getWinner() != null) {
			UserEntity winner = userRepository.getReferenceById(auctionDto.getWinner());
			model.addAttribute("winner", winner);
		} 
		
		UserEntity user = userRepository.findByEmail(userDetail.getUsername());
		model.addAttribute("currentUserId", user.getUserId());
		int sellerId = user.getUserId();
//		int sellerId = 2953; // test용
		model.addAttribute("loginUserId", sellerId);
		
		return "thymeleaf/item/auction/view";
	}
	
	// 입찰 폼 열기
	@GetMapping("/bid/{itemId}")
	public String bidForm(@PathVariable int itemId, Model model) {
		AuctionDto auction = auctionService.findById(itemId);
		BidDto bidDto = new BidDto();
		bidDto.setItem(auction.toEntity(auction));
		model.addAttribute("bidDto", bidDto);
//		model.addAttribute("auction", auction);
		return "thymeleaf/item/auction/bidForm";
	}
}
