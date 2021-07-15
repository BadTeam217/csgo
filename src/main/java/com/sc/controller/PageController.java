package com.sc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.StringIdGenerator;

@Controller
@RequestMapping("/")
public class PageController {
	@RequestMapping("doIndexUI")
	public String doIndexUI() {
		return "Index";
	}

	@RequestMapping("user")
	public String showUser() {
		return "User";
	}
}
