package com.sc.dao;

import com.sc.pojo.Market;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class MarketDaoTest {
    @Autowired
    MarketDao marketDao;

    @Test
    void insert(){
        System.out.println(marketDao.insert(new Market(3, 2, 150.32d, new Date())));
    }

    @Test
    void findItemsBySellerId(){
        System.out.println(marketDao.findItemsBySellerId(1));
    }
    @Test
    void findSellerByItemId(){
        System.out.println(marketDao.findSellerByItemId(2));
    }
}
