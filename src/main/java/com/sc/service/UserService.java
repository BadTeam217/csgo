package com.sc.service;

import com.sc.pojo.User;

public interface UserService {

    public int insertUser(User user);

    public User findUserByAccount(String account);

    public int update(User user);
    
    public User findUserById(int id);
}
