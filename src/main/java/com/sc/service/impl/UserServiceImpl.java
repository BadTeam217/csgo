package com.sc.service.impl;

import com.sc.dao.BuyerDao;
import com.sc.dao.SellerDao;
import com.sc.dao.UserDao;
import com.sc.pojo.Buyer;
import com.sc.pojo.Seller;
import com.sc.pojo.User;
import com.sc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    BuyerDao buyerDao;
    @Autowired
    SellerDao sellerDao;


    @Override
    @Transactional
    public int insertUser(User user) {
        if (user.getName() != null && user.getAccount() != null && user.getPassword() != null){
            //空值判断
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            int result = userDao.insertObject(user);
            Integer id = user.getId();
            //卖家身份、买家身份
            buyerDao.insert(new Buyer(0,id));
            sellerDao.insert(new Seller(0, id));
            return result;
        }else return 0;

    }

    @Override
    public User findUserByAccount(String account) {
        return userDao.findUserByAccount(account);
    }

    @Override
    public int update(User user) {
        if (user.getId() != null && user.getName() != null && user.getPassword() != null && user.getAccount() != null){
        	user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userDao.updateObjectById(user);
        }
        return -1;
    }
}
