package com.hotSix.itemrier_boot.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
@Data
public class AddressDto {
	private int zipcode;
	private String addStreet;
	private String addDetail;
	
}
