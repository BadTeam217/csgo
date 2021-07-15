package com.sc.dao;

import com.sc.pojo.Stock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StockDaoTest {
    @Autowired
    StockDao stockDao;

    @Test
    void insert(){
        System.out.println(stockDao.insert(new Stock(1, 1)));
    }

    @Test
    void findItemsByUserId(){
        System.out.println(stockDao.findItemsByUserId(1));
    }
    @Test
    void findUserByItemId(){
        System.out.println(stockDao.findUserByItemId(1));
    }
    @Test
    void delete(){
        System.out.println(stockDao.delete(new Stock(1, 1)));
    }
}
