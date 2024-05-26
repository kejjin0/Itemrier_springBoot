package com.hotSix.itemrier_boot.service.user;

import org.springframework.stereotype.Service;

import com.hotSix.itemrier_boot.dto.user.UserDto;
import com.hotSix.itemrier_boot.repository.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	
	public void insertUser(UserDto userDto) {
		userRepository.save(userDto.toUserEntity(userDto));
	}
}
