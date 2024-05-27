package com.hotSix.itemrier_boot.domain.order;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryInfo {
	@Column(nullable = false)
	private String zipCode;
	@Column(nullable = false)
	private String addStreet;
	@Column(nullable = false)
	private String addDetail;
	
	private String deliveryLocation;
	private String deliveryRequest;
	

}