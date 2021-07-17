package com.sc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {

	@RequestMapping("doIndexUI")
	public String doIndexUI() {
		return "Index";
	}

	@RequestMapping("userinfo")
	public String showUser() {
		return "User";
	}

	@GetMapping("ll")
	public String ll() {
		return "login";
	}
}
