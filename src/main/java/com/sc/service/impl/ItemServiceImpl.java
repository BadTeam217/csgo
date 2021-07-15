package com.sc.service.impl;

import com.sc.dao.ItemDao;
import com.sc.pojo.Item;
import com.sc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemDao itemDao;
    @Override
    public int insert(Item item) {
        return itemDao.insert(item);
    }

    @Override
    public int delete(Integer id) {
        return itemDao.delete(id);
    }

    @Override
    public int update(Item item) {
        return itemDao.update(item);
    }

    @Override
    public Item findItemById(Integer id) {
        return itemDao.findItemById(id);
    }

    @Override
    public List<Item> findAllItems() {
        return itemDao.findAllItems();
    }
}
