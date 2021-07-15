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
}
