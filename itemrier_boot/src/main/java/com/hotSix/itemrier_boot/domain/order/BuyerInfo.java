package com.hotSix.itemrier_boot.domain.order;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class BuyerInfo {
	@Column(nullable = false)
	private String buyerName;	// 구매자 이름
	@Column(nullable = false)
	private String phoneNum;	// 구매자 전화번호
}
