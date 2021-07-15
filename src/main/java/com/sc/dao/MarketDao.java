package com.sc.dao;

import com.sc.pojo.Item;
import com.sc.pojo.Market;
import com.sc.pojo.Seller;
import com.sc.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MarketDao {

    public int insert(Market market);

    public int delete(Market market);

    public List<Item> findItemsBySellerId(Integer seller_id);

    public Seller findSellerByItemId(Integer item_id);

}
