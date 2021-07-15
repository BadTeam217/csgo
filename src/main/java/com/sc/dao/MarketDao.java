package com.sc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sc.pojo.Item;
import com.sc.pojo.Market;
import com.sc.pojo.Seller;
import com.sc.vo.MarketVo;

@Mapper
public interface MarketDao {

	public int insert(Market market);

	public int delete(Market market);

	public List<Item> findItemsBySellerId(Integer seller_id);

	public Seller findSellerByItemId(Integer item_id);

	List<MarketVo> findPageObject(long startIndex, long pageSize);

	List<MarketVo> findPageObjectByPrice(long startIndex, long pageSize);

	@Select("select count(*) from market")
	long getRowCount();
}
