package com.sc.controller;

import com.sc.pojo.User;
import com.sc.service.UserService;
import com.sc.util.ResponseMsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    @ResponseBody
    public String register(User user){
        //登录功能
        int result = userService.insertUser(user);
        return ResponseMsgUtil.getResult(result);
    }
}
