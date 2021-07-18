package com.sc.dao;

import com.sc.pojo.Buyer;
import com.sc.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BuyerDao {

	public int insert(Buyer buyer);

	public User findUserByBuyerId(Integer id);

	@Select("select * from buyer where user_id=#{user_id}")
	Buyer findBuyerByUserId(Integer user_id);
}
