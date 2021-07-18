package com.sc.dao;

import com.sc.pojo.Buyer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BuyerDaoTest {
    @Autowired
    BuyerDao buyerDao;
    @Test
    void insert(){
        System.out.println(buyerDao.insert(new Buyer(1, 1)));
    }

    @Test
    void findUserByBuyer(){

    }
}
