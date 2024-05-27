package com.hotSix.itemrier_boot.domain.review;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter 
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Review {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int reivewId;	// 리뷰 아이디
	private int userId;		// 사용자 아이디
	private int itemId;		// 구매 또는 판매한 물품 아이디
	private int reviewerId;		// 리뷰를 작성한 유저 아이디
	private Double satisfactionRate;	// 평균 만족도
	private Double speedOfAnswer;		// 평균 답장 속도 점수
	private Double promise;		// 평균 약속 지킴에 대한 점수
	
}