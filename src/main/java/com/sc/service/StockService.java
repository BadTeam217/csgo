package com.sc.service;

import com.sc.pojo.Item;
import com.sc.pojo.Stock;
import com.sc.pojo.User;

import java.util.List;

public interface StockService {

    public int insert(Stock stock);

    public int delete(Stock stock);

    public List<Item> findItemsByUserId(Integer user_id);

    public User findUserByItemId(Integer item_id);
}
