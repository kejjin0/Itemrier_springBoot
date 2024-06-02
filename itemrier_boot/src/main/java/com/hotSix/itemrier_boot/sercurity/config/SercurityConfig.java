package com.hotSix.itemrier_boot.sercurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import com.hotSix.itemrier_boot.sercurity.handler.CustomAuthenticationSuccessHandler;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SercurityConfig {

	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http	.csrf(AbstractHttpConfigurer::disable)
				.httpBasic(AbstractHttpConfigurer::disable)
				.formLogin(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests((authorize) -> authorize
						.requestMatchers("/myPage/**").authenticated()
						.anyRequest().permitAll())
				
				// 폼 로그인은 현재 사용하지 않음         
				.formLogin(formLogin -> formLogin
						.loginProcessingUrl("/user/login")
						.usernameParameter("email")
						.successHandler(new CustomAuthenticationSuccessHandler())
						.permitAll())
				
				.logout((logout) -> logout
						.logoutSuccessUrl("/login")
						.invalidateHttpSession(true)
				
		);
		
		return http.build();
	}
	


		
		
}
