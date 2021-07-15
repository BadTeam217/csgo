package com.sc.dao;

import com.sc.pojo.Item;
import com.sc.pojo.Stock;
import com.sc.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface StockDao {
    public int insert(Stock stock);

    public int delete(Stock stock);

    public List<Item> findItemsByUserId(Integer user_id);

    public User findUserByItemId(Integer item_id);
}
