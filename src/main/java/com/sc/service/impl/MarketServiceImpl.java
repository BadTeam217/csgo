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
import org.springframework.transaction.annotation.Transactional;

@Service
public class MarketServiceImpl implements MarketService {
	@Autowired
	private MarketDao marketDao;
	@Autowired
	private StockDao stockDao;
	@Autowired
	private SellerDao sellerDao;

	@Override
	public PageObject<MarketVo> findPageObject(Long pageCurrent, String type, String skin, String quality) {
		// 参数校验
		if (pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("当前页码值无效");
		// 查询当前页记录
		long rowCount = marketDao.getRowCount(null);
		int pageSize = 5;
		long sum = pageSize;
		long startIndex = (pageCurrent - 1) * pageSize;
		List<MarketVo> results = marketDao.findPageObject(startIndex, rowCount);
		List<MarketVo> records = new ArrayList<>();
		for (MarketVo r : results) {
			if (type != null && r.getItem().getType().indexOf(type) == -1) {
				rowCount--;
				continue;
			}
			if (skin != null && r.getItem().getSkin().indexOf(skin) == -1) {
				rowCount--;
				continue;
			}
			if (quality != null && r.getItem().getQuality().indexOf(quality) == -1) {
				rowCount--;
				continue;
			}
			records.add(r);
			sum--;
			if (sum == 0)
				break;
		}
		if (rowCount == 0)
			throw new IllegalArgumentException("无记录");
		// 封装查询结果
		return new PageObject<>(records, rowCount, pageSize, pageCurrent);
	}

	@Override
	@Transactional
	public int putOnShelf(Market market) {
		if (market.getItem_id() != null && market.getSeller_id() != null && market.getPrice() != null
				&& market.getDatetime() != null) {
			if (stockDao.findStockByItemAndUser(
					sellerDao.findUserBySeller(sellerDao.findSellerBySellerId(market.getSeller_id())).getId(),
					market.getItem_id()) != null) {
				// 确保仓库中有该物品
				int result = marketDao.insert(market);
				// 上架时从仓库移除该物品
				stockDao.delete(market.getItem_id());
				return result;
			} else
				return -1;
		}
		return 0;
	}

	@Override
	@Transactional
	public int offShelf(Market market) {
		if (market.getItem_id() != null && market.getSeller_id() != null) {
			if (marketDao.findMarketBYItem(market.getItem_id()) != null) {
				Seller seller = sellerDao.findSellerBySellerId(market.getSeller_id());
				User user = sellerDao.findUserBySeller(seller);
				// 下架时往仓库添加该物品
				stockDao.insert(new Stock(user.getId(), market.getItem_id()));
				int result = marketDao.delete(market);
				return result;
			} else
				return -1;
		}
		return 0;
	}

	@Override
	public List<Item> findItemsBySellerId(Integer seller_id) {
		if (seller_id != null) {
			List<Item> items = marketDao.findItemsBySellerId(seller_id);
			return items;
		}
		return null;
	}

	@Override
	public Seller findSellerByItemId(Integer item_id) {
		if (item_id != null) {
			return marketDao.findSellerByItemId(item_id);
		}
		return null;
	}

	@Override
	public PageObject<MarketVo> findPageObjectByPrice(Long pageCurrent) {
		// 参数校验
		if (pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("当前页码值无效");
		// 查询当前页记录
		int pageSize = 5;
		long startIndex = (pageCurrent - 1) * pageSize;
		List<MarketVo> records = marketDao.findPageObjectByPrice(startIndex, pageSize);
		long rowCount = marketDao.getRowCount(null);
		// 封装查询结果
		return new PageObject<>(records, rowCount, pageSize, pageCurrent);
	}

	@Override
	public PageObject<MarketVo> findPageObjectsOnShelf(Integer user_id, Long pageCurrent) {
		// 参数校验
		if (pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("当前页码值无效");
		// 查询当前页记录
		int pageSize = 5;
		long startIndex = (pageCurrent - 1) * pageSize;
		Seller seller = sellerDao.findSellerByUserId(user_id);
		List<MarketVo> records = marketDao.findPageObjectOnShelf(seller.getId(), startIndex, pageSize);
		long rowCount = marketDao.getRowCount(seller.getId());
		// 封装查询结果
		return new PageObject<>(records, rowCount, pageSize, pageCurrent);
	}

}
