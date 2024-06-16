package com.hotSix.itemrier_boot.controller.user;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hotSix.itemrier_boot.domain.user.UserEntity;
import com.hotSix.itemrier_boot.dto.user.UserDto;
import com.hotSix.itemrier_boot.repository.user.UserRepository;
import com.hotSix.itemrier_boot.service.user.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	private final UserRepository userRepository;
	//private final BCryptPasswordEncoder encoder;
	
	@GetMapping("/user/login/form") // 로그인
	public String login() {
		return "join/login";
	}
	
	@GetMapping("/user/register/form")
	public String resisterUser() {
		return "join/joinForm";
	}
	
	@ResponseBody
	@PostMapping("/user/register") //회원가입
	public UserDto registerUser(@RequestBody UserDto userDto) {		
		userService.insertUser(userDto);
		
		return userDto;
	}
	
	@ResponseBody
	@PostMapping("/myPage/change") 
	public UserDto changeUser(@AuthenticationPrincipal UserDetails userDetail, @RequestBody UserDto userDto) {
		UserEntity user = userRepository.findByEmail(userDetail.getUsername()); 
		int userId = user.getUserId(); //로그인한 계정의 PK값
		//userDto.setPassword(encoder.encode(userDto.getPassword()));
		
		userService.insertUser(userDto);
		
		return userDto;
	}
	
}
