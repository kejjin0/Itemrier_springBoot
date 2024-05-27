package com.hotSix.itemrier_boot.controller.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotSix.itemrier_boot.dto.user.UserDto;
import com.hotSix.itemrier_boot.service.user.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

	private final UserService userService;
	private final BCryptPasswordEncoder encoder;
	
	@PostMapping("/register") 
	public String registerUser(@RequestBody UserDto userDto) {
		userDto.setPassword(encoder.encode(userDto.getPassword()));
		
		userService.insertUser(userDto);
		
		return "joinFinish";
	}
	
	@PostMapping("/change") 
	public String changeUser(@RequestBody UserDto userDto) {
		userDto.setPassword(encoder.encode(userDto.getPassword()));
		
		userService.insertUser(userDto);
		
		return "joinFinish";
	}
}
