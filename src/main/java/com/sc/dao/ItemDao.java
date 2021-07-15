package com.sc.dao;

import com.sc.pojo.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ItemDao {

    public int insert(Item item);

    public int delete(Integer id);

    public int update(Item item);

    public Item findItemById(Integer id);

    public List<Item> findAllItems();

}
