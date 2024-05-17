package com.hotSix.itemrier_boot.domain.Review;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter @ToString
public class Review {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int reivewId;	// 리뷰 아이디
	private int userId;		// 사용자 아이디
	private int itemId;		// 구매 또는 판매한 물품 아이디
	private String itemType; 	// 중고 거래? 공구? 경매?
	private int reviewerId;		// 리뷰를 작성한 유저 아이디
	private Double satisfactionRate;	// 평균 만족도
	private Double speedOfAnswer;		// 평균 답장 속도 점수
	private Double promise;		// 평균 약속 지킴에 대한 점수
	
	public Review() {
	}

	@Builder
	public Review(int reivewId, int userId, int itemId, String itemType, int reviewerId, Double satisfactionRate,
			Double speedOfAnswer, Double promise) {
		super();
		this.reivewId = reivewId;
		this.userId = userId;
		this.itemId = itemId;
		this.itemType = itemType;
		this.reviewerId = reviewerId;
		this.satisfactionRate = satisfactionRate;
		this.speedOfAnswer = speedOfAnswer;
		this.promise = promise;
	}
}

