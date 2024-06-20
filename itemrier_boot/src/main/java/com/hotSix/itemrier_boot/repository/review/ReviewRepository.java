package com.hotSix.itemrier_boot.repository.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hotSix.itemrier_boot.domain.review.Review;
import com.hotSix.itemrier_boot.dto.review.ReviewDto;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	// 작성 여부 확인
	Boolean existsByReviewerIdAndItemId(int reviewerId, int itemId);

	// item의 평균 리뷰 가져오기
	@Query("SELECT new com.hotSix.itemrier_boot.dto.review.ReviewDto (AVG(r.satisfactionRate), AVG(r.speedOfAnswer), AVG(r.promise)) "
			+ "FROM Review r WHERE r.itemId = :itemId")
	ReviewDto findAverageByItemId(@Param("itemId") int itemId);

	// 사용자의 평균 리뷰 별점
	@Query("SELECT new com.hotSix.itemrier_boot.dto.review.ReviewDto("
			+ "AVG(r.satisfactionRate), AVG(r.speedOfAnswer), AVG(r.promise)) "
			+ "FROM Review r WHERE r.userId = :userId")
	ReviewDto findAverageByUserId(@Param("userId") int userId);
}
