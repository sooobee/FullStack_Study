package com.canesblack.spring_project1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.canesblack.spring_project1.entity.Menu;
import com.canesblack.spring_project1.entity.User;
import com.canesblack.spring_project1.service.MenuRestService;
import com.canesblack.spring_project1.service.UserService;


import jakarta.servlet.http.HttpServletRequest;

// 
@Controller
public class PageController {
	
	@Autowired
	private MenuRestService menuRestService;
	
	@Autowired
	private UserService userService;
	
	// 페이지를 조회,이동할 때 getMapping 사용
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	// 로그인 페이지
	@GetMapping("/loginPage")
	public String loginPage(HttpServletRequest request,org.springframework.ui.Model model) {
		
		// csrf 처리를 해줘야 정보가 넘어감
		CsrfToken csrfToken = (CsrfToken)request.getAttribute(CsrfToken.class.getName());
		
		model.addAttribute("_csrf", csrfToken);
		
		return "login/index";
	}
	 
	// 회원가입 화면
	// Controller -> View 단으로 request 보냄
	@GetMapping("/registerPage")
	public String registerPage(HttpServletRequest request,org.springframework.ui.Model model) {
		
		// csrf 처리를 해줘야 정보가 넘어감
		CsrfToken csrfToken = (CsrfToken)request.getAttribute(CsrfToken.class.getName());
		model.addAttribute("_csrf", csrfToken);
		
		return "register/index";
	}
	
	 @GetMapping("/noticeAddPage")
	 public String noticeAddPage(Model model, Authentication authentication) {
		 String writer = userService.findWriter(authentication.getName());
		 model.addAttribute("writer", writer);
		 
		 return "noticeAdd/index";
	 }
	 
	 @GetMapping("/noticeCheckPage")
	 // idx에 idx값을 넣어 붙힘 
	 public String showNoticeCheckPage(@RequestParam("idx") int idx, Model model) {
		 // 해당 idx의 게시물을 가져옴
		 Menu menu = menuRestService.boardContent(idx);
		 model.addAttribute("menu", menu);
		 
		 return "noticeCheck/index"; 
	 }
	 
	 @GetMapping("/noticeModifyPage")
	 // idx에 idx값을 넣어 붙힘 
	 public String showNoticeModifyPage(@RequestParam("idx") int idx, Model model) {
		 // 해당 idx의 게시물을 가져옴
		 Menu menu = menuRestService.boardContent(idx);
		 model.addAttribute("menu", menu);
		 
		 return "noticeModify/index"; 
	 }
}
