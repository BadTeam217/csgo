package com.sc.dao;

import org.apache.ibatis.annotations.Mapper;

import com.sc.pojo.Item;

@Mapper
public interface ItemDao {
	Item findObjectById(Integer id);

}
