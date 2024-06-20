package com.hotSix.itemrier_boot.controller.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotSix.itemrier_boot.domain.review.Review;
import com.hotSix.itemrier_boot.domain.user.UserEntity;
import com.hotSix.itemrier_boot.repository.user.UserRepository;
import com.hotSix.itemrier_boot.service.review.ReviewService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private UserRepository userRepository;
	
	// 리뷰 작성하기 (폼)
	@GetMapping("/write/reviewForm")
	public String viewRevieForm(@AuthenticationPrincipal UserDetails userDetail, @RequestParam(value="itemId", defaultValue = "-1") int itemId, @RequestParam(value="userId", defaultValue = "-1")int userId, Model model) throws Exception {
		if (itemId==-1||userId==-1) {
			model.addAttribute("message", "오류가 발생했습니다.");
			return "review/result";
		}
		
		UserEntity user = userRepository.findByEmail(userDetail.getUsername());
		int reviewerId = user.getUserId();
		boolean rslt = reviewService.conformExistReview(reviewerId, itemId);
		String url;
		if(rslt==true) {
			model.addAttribute("message", "이미 작성하셨습니다.");
			url = "review/result";
		}else {
			url = "review/reviewForm";
			model.addAttribute("userId", userId);
			model.addAttribute("itemId", itemId);
			model.addAttribute("reviewerId", reviewerId);
		}
		return url;
	}
	
	// 리뷰 작성
	@PostMapping("/wrtie/review")
	public String writeReview(@ModelAttribute("review") Review review, Model model) {
		reviewService.insertReview(review);
		model.addAttribute("message", "리뷰 작성이 완료되었습니다.");
		return "review/result";
	}
	
	// item의 평균 리뷰 가져오기
	@GetMapping("/view/itemReview")
	public String viewItemAverageReview(int itemId, Model model) {
		Review review = reviewService.getAverageByItemId(itemId);
		model.addAttribute("review", review);
		return "review/reviewScore";
	}
	
	// 사용자 평균 리뷰 별점
	@GetMapping("/view/userReview")
	public String viewUserAverageScore(int userId, Model model) {
		Review review = reviewService.getAverageByUserId(userId);
		model.addAttribute("review", review);
		return "review/reviewScore";
	}
}
