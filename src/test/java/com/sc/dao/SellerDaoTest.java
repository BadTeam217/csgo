package com.sc.dao;

import com.sc.pojo.Seller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SellerDaoTest {
    @Autowired
    SellerDao sellerDao;
    @Test
    void insert(){
        System.out.println(sellerDao.insert(new Seller(1, 1)));
    }

    @Test
    void findUserBySeller(){
        System.out.println(sellerDao.findUserBySeller(new Seller(1, 1)));
    }
}
