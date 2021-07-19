package com.sc.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.common.vo.JsonResult;
import com.sc.pojo.User;
import com.sc.service.UserService;
import com.sc.util.ResponseMsgUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/register")
	@ResponseBody
	public String register(User user) {
		// 注册功能
		int result = userService.insertUser(user);
		return ResponseMsgUtil.getResult(result);
	}

	@GetMapping("/auth")
	@ResponseBody
	public String getAuth(Principal principal) {
		if (principal != null) {
			// 当前有用户登录
			User user = userService.findUserByAccount(principal.getName());
			if (user != null) {
				return ResponseMsgUtil.getResponseMsg("result", "success", "userID", user.getId());
			} else {
				return ResponseMsgUtil.getResult("notExist");
			}
		}
		return ResponseMsgUtil.getResult(0);
	}

	@PutMapping("/update")
	@ResponseBody
	public String updateUser(User user) {
		int result = userService.update(user);
		if (result != -1) {
			return ResponseMsgUtil.getResult(result);
		} else
			return ResponseMsgUtil.getResult("noVars");
	}
}
