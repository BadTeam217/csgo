package com.sc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sc.pojo.Item;
import com.sc.pojo.Market;
import com.sc.pojo.Seller;
<<<<<<< HEAD
import com.sc.vo.MarketVo;
=======
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
>>>>>>> f5e43cd432c5ef3490e5f42f56f85acb99e69836

@Mapper
public interface MarketDao {

	public int insert(Market market);

	public int delete(Market market);

	public List<Item> findItemsBySellerId(Integer seller_id);

	public Seller findSellerByItemId(Integer item_id);

	List<MarketVo> findPageObject(long startIndex, long pageSize);
}
