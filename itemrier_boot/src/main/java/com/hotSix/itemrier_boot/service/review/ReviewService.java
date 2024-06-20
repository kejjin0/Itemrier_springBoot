package com.hotSix.itemrier_boot.service.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotSix.itemrier_boot.domain.review.Review;
import com.hotSix.itemrier_boot.dto.review.ReviewDto;
import com.hotSix.itemrier_boot.repository.review.ReviewRepository;

@Service
public class ReviewService {
	@Autowired
	ReviewRepository reviewRepository;
	
	//작성 여부 확인
	public boolean conformExistReview(int reviewerId, int itemId) {
		boolean rslt = reviewRepository.existsByReviewerIdAndItemId(reviewerId, itemId);
		return rslt;
	}
	
	// 리뷰 작성
	public void insertReview(Review review) {
		reviewRepository.save(review);
	}
	
	// item의 평균 리뷰 가져오기
	public Review getAverageByItemId(int itemId) {
		ReviewDto result = reviewRepository.findAverageByItemId(itemId);
		
        Review review = new Review();
		if (result!=null ) {
			review.setSatisfactionRate(result.getSatisfactionRate());
			review.setSpeedOfAnswer(result.getSpeedOfAnswer());
			review.setPromise(result.getPromise());
		}else {
			review.setSatisfactionRate(0.0);
			review.setSpeedOfAnswer(0.0);
			review.setPromise(0.0);
		}
		return review;
	}
	
	// 사용자 평균 리뷰 별정
	public Review getAverageByUserId(int userId) {
		ReviewDto result = reviewRepository.findAverageByUserId(userId);
		
		Review review = new Review();
		if (result!=null ) {
			review.setSatisfactionRate(result.getSatisfactionRate());
			review.setSpeedOfAnswer(result.getSpeedOfAnswer());
			review.setPromise(result.getPromise());
		}else {
			review.setSatisfactionRate(0.0);
			review.setSpeedOfAnswer(0.0);
			review.setPromise(0.0);
		}
		return review;
	}

}
