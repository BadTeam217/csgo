package com.sc.dao;

import com.sc.pojo.Buyer;
import com.sc.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BuyerDao {

    public int insert(Buyer buyer);

    public User findUserByBuyer(Buyer buyer);
}
