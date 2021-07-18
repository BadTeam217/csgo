package com.sc.service;

import com.sc.common.vo.PageObject;
import com.sc.pojo.Item;
import com.sc.pojo.Market;
import com.sc.pojo.Seller;
import com.sc.vo.MarketVo;

import java.util.List;

public interface MarketService {
	/** 查询所有商品 */
	PageObject<MarketVo> findPageObject(Long pageCurrent, String type, String skin, String quality);

	PageObject<MarketVo> findPageObjectByPrice(Long pageCurrent);

	public int putOnShelf(Market market);

	public int offShelf(Market market);

	public List<Item> findItemsBySellerId(Integer seller_id);

	public Seller findSellerByItemId(Integer item_id);

	/** 查询该用户上架的道具 */
	PageObject<MarketVo> findPageObjectsOnShelf(Integer user_id, Long pageCurrent);

}
