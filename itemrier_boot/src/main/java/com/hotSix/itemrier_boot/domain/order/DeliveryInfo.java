package com.hotSix.itemrier_boot.domain.order;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryInfo {
	private String zipCode;
	private String addStreet;
	private String addDetail;
	private String deliveryLocation;
	private String deliveryRequest;
	
	public DeliveryInfo(String zipCode, String addStreet, String addDetail, String deliveryLocation,
			String deliveryRequest) {
		super();
		this.zipCode = zipCode;
		this.addStreet = addStreet;
		this.addDetail = addDetail;
		this.deliveryLocation = deliveryLocation;
		this.deliveryRequest = deliveryRequest;
	}

}