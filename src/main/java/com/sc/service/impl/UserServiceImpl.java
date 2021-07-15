package com.sc.service.impl;

import com.sc.dao.UserDao;
import com.sc.pojo.User;
import com.sc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public int insertUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDao.insertObject(user);
    }
}
