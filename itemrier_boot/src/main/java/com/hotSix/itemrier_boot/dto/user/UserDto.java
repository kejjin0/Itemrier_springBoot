package com.hotSix.itemrier_boot.dto.user;


import com.hotSix.itemrier_boot.domain.user.UserEntity;

import lombok.*;


@NoArgsConstructor(force = true)
@Data
public class UserDto {
    private int userId;

	private String email;

	private String password;

	private String name;

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
