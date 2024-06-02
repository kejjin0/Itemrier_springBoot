package com.hotSix.itemrier_boot.controller.user;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotSix.itemrier_boot.dto.user.UserDto;
import com.hotSix.itemrier_boot.service.user.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

	private final UserService userService;
	//private final BCryptPasswordEncoder encoder;
	
	
	@PostMapping("/register") 
	public UserDto registerUser(@RequestBody UserDto userDto) {		
		userService.insertUser(userDto);
		
		return userDto;
	}
	
	@PostMapping("/change") 
	public UserDto changeUser(@RequestBody UserDto userDto) {
		//userDto.setPassword(encoder.encode(userDto.getPassword()));
		
		userService.insertUser(userDto);
		
		return userDto;
	}
	
}
