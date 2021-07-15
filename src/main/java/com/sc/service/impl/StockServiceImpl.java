package com.sc.service.impl;

import com.sc.dao.StockDao;
import com.sc.pojo.Item;
import com.sc.pojo.Stock;
import com.sc.pojo.User;
import com.sc.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StockServiceImpl implements StockService {
    @Autowired
    StockDao stockDao;
    @Override
    public int insert(Stock stock) {
        return stockDao.insert(stock);
    }

    @Override
    public int delete(Stock stock) {
        return stockDao.delete(stock);
    }

    @Override
    public List<Item> findItemsByUserId(Integer user_id) {
        return findItemsByUserId(user_id);
    }

    @Override
    public User findUserByItemId(Integer item_id) {
        return stockDao.findUserByItemId(item_id);
    }
}
