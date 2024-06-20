package com.hotSix.itemrier_boot.dto.review;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(force = true)
@Getter
@Setter
@AllArgsConstructor
public class ReviewDto {
	private Double satisfactionRate;
	private Double speedOfAnswer;
	private Double promise;
}
