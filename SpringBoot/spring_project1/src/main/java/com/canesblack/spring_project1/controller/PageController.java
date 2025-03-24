package com.canesblack.spring_project1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	// 페이지를 조회,이동할 때 getMapping 사용
	@GetMapping("/")
	public String returnHome() {
		return "index";
	}
}
