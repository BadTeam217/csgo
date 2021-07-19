package com.sc.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sc.pojo.Seller;
import com.sc.pojo.User;

@Mapper
public interface SellerDao {

	public int insert(Seller seller);

	public User findUserBySeller(Seller seller);

	User findUserBySellerId(Integer id);

	public Seller findSellerBySellerId(Integer seller_id);

	@Select("select * from seller where user_id=#{user_id}")
	Seller findSellerByUserId(Integer user_id);

	public Integer findSellerIdByIuserId(Integer user_id);
}
