package com.sc.service;

import com.sc.common.vo.PageObject;
import com.sc.pojo.Item;
import com.sc.pojo.Market;
import com.sc.pojo.Seller;
import com.sc.vo.MarketVo;

import java.util.List;

public interface MarketService {

	PageObject<MarketVo> findPageObjects(Long pageCurrent, String type, String skin, String quality);

	public int putOnShelf(Market market);

	public int offShelf(Market market);

	public List<Item> findItemsBySellerId(Integer seller_id);

	public Seller findSellerByItemId(Integer item_id);



}
