package com.sc.dao;

import com.sc.pojo.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ItemDaoTest {
    @Autowired
    ItemDao itemDao;

    @Test
    void insert(){
        Item item = new Item(0, "AK-47", "火神", "红色");
        System.out.println(itemDao.insert(item));
    }

    @Test
    void findItemById(){
        System.out.println(itemDao.findItemById(1));
    }
    @Test
    void findAllItems(){
        System.out.println(itemDao.findAllItems());
    }
}
