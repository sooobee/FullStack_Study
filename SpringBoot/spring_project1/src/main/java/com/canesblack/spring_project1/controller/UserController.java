package com.canesblack.spring_project1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.canesblack.spring_project1.entity.Role;
import com.canesblack.spring_project1.entity.User;
import com.canesblack.spring_project1.service.UserService;

@Controller
public class UserController {
	
	//의존성 주입
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	// register 로 이동할 때 user 정보를 파라미터로 가진 채 이동 
	public String register(@ModelAttribute User user) {
		
		String userPassword = user.getPassword();
		System.out.println("!!!!!!!!!!userPassword: "+userPassword);
		
		user.setRole(Role.MEMBER); // 멤버로 지정 
		
		String passwordEncoded = passwordEncoder.encode(userPassword); // 암호화
		
		user.setPassword(passwordEncoded); // 암호화된 패스워드 담김 
		
		userService.insertUser(user); // 유저 정보를 데이터베이스에 저장 
		
		// 다시 로그인 화면으로 리다이렉팅
		return "redirect:/loginPage";
	}
	
	

}
