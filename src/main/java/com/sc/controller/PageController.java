package com.sc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.StringIdGenerator;

@Controller
@RequestMapping("/")
public class PageController {
	@RequestMapping("doIndexUI")
	public String doIndexUI() {
		return "Index";
	}

<<<<<<< HEAD
	@RequestMapping("user")
	public String showUser() {
		return "User";
=======
	@GetMapping("/ll")
	public String ll(){
		return "login";
>>>>>>> fb3a805e1e3ae58272fa6820be929850bcc12f78
	}
}
