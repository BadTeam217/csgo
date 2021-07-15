package com.sc.dao;

import com.sc.pojo.Seller;
import com.sc.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SellerDao {

    public int insert(Seller seller);

    public User findUserBySeller(Seller seller);

}
