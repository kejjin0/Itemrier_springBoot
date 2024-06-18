package com.hotSix.itemrier_boot.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import lombok.Data;

@Data
public class ProfileDto {
private String name;

	@NotBlank(message = "- 제외 휴대폰 번호를 입력해주세요.")
    @Pattern(regexp = "(01[016789])(\\d{3,4})(\\d{4})", message = "올바른 휴대폰 번호를 입력해주세요.")
	private String phoneNum;

	private String nickname;
	
	private int zipcode;
	
	private String addStreet;

	private String addDetail;


}
