package com.hotSix.itemrier_boot.dto.user;


import com.hotSix.itemrier_boot.domain.user.UserEntity;

import jakarta.validation.constraints.*;
import lombok.*;


@NoArgsConstructor(force = true)
@Data
public class UserDto {
    private int userId;

    @NotBlank(message = "이메일 주소를 입력해주세요.")
    @Email(message = "올바른 이메일 주소를 입력해주세요.")
	private String email;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이하로 입력해주세요.")
	private String password;

	private String name;

	@NotBlank(message = "- 제외 휴대폰 번호를 입력해주세요.")
    @Pattern(regexp = "(01[016789])(\\d{3,4})(\\d{4})", message = "올바른 휴대폰 번호를 입력해주세요.")
	private String phoneNum;

	private String nickname;
	
	private int zipcode;
	
	private String addStreet;

	private String addDetail;
	
	public UserDto toUserDto(UserEntity userEntity) {
		UserDto userDto = new UserDto();
		userDto.setUserId(userEntity.getUserId());
        userDto.setEmail(userEntity.getEmail());
        userDto.setPassword(userEntity.getPassword());
        userDto.setName(userEntity.getName());
        userDto.setPhoneNum(userEntity.getPhoneNum());
        userDto.setNickname(userEntity.getNickname());
        userDto.setZipcode(userEntity.getZipcode());
        userDto.setAddStreet(userEntity.getAddStreet());
        userDto.setAddDetail(userEntity.getAddDetail());
        
		return userDto;
	}

	public UserEntity toUserEntity(UserDto userDto) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(userDto.getUserId());
		userEntity.setEmail(userDto.getEmail());
		userEntity.setPassword(userDto.getPassword());
		userEntity.setName(userDto.getName());
		userEntity.setPhoneNum(userDto.getPhoneNum());
		userEntity.setNickname(userDto.getNickname());
		userEntity.setZipcode(userDto.getZipcode());
		userEntity.setAddStreet(userDto.getAddStreet());
		userEntity.setAddDetail(userDto.getAddDetail());
        
		return userEntity;		
	}

}
