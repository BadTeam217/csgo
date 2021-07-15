package com.sc.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.sc.dao.SellerDao;
import com.sc.dao.StockDao;
import com.sc.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.common.vo.PageObject;
import com.sc.dao.MarketDao;
import com.sc.service.MarketService;
import com.sc.vo.MarketVo;

@Service
public class MarketServiceImpl implements MarketService {
	@Autowired
	private MarketDao marketDao;
	@Autowired
	private StockDao stockDao;
	@Autowired
	private SellerDao sellerDao;

	@Override
	public PageObject<MarketVo> findPageObjects(Long pageCurrent, String type, String skin, String quality) {
		// 参数校验
		if (pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("当前页码值无效");
		// 查询当前页记录
		int pageSize = 5;
		long startIndex = (pageCurrent - 1) * pageSize;
		List<MarketVo> results = marketDao.findPageObject(startIndex, pageSize);
		List<MarketVo> records = new ArrayList<>();
		for (MarketVo r : results) {
			boolean flag = true;
			if (type != null && r.getItem().getType().indexOf(type) == -1)
				flag = false;
			if (skin != null && r.getItem().getSkin().indexOf(skin) == -1)
				flag = false;
			if (quality != null && r.getItem().getQuality().indexOf(quality) == -1)
				flag = false;
			if (flag)
				records.add(r);
		}
		if (records.size() == 0)
			throw new IllegalArgumentException("无记录");
		long rowCount = records.size();
		// 封装查询结果
		return new PageObject<>(records, rowCount, pageSize, pageCurrent);
	}

	@Override
	public int putOnShelf(Market market) {
		if (market.getItem_id() !=null && market.getSeller_id() != null && market.getPrice() != null && market.getDatetime() != null){
			//上架时从仓库移除该物品
			int result = marketDao.insert(market);
			stockDao.delete(market.getItem_id());
			return result;
		}
		return 0;
	}

	@Override
	public int offShelf(Market market) {
		if (market.getItem_id() != null && market.getSeller_id() != null && market.getPrice() != null && market.getDatetime() != null){
			//下架时往仓库添加该物品
			Seller seller = sellerDao.findSellerBySellerId(market.getSeller_id());
			User user = sellerDao.findUserBySeller(seller);
			stockDao.insert(new Stock(user.getId(), market.getItem_id()));
			int result = marketDao.delete(market);
			return  result;
		}
		return 0;
	}

	@Override
	public List<Item> findItemsBySellerId(Integer seller_id) {
		if (seller_id != null){
			List<Item> items = marketDao.findItemsBySellerId(seller_id);
			return items;
		}
		return null;
	}

	@Override
	public Seller findSellerByItemId(Integer item_id) {
		if (item_id != null){
			return marketDao.findSellerByItemId(item_id);
		}
		return null;
	}

}
