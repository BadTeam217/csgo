package com.sc.service;

import com.sc.pojo.Item;

import java.util.List;

public interface ItemService {

    public int insert(Item item);

    public int delete(Integer id);

    public int update(Item item);

    public Item findItemById(Integer id);

    public List<Item> findAllItems();

}
