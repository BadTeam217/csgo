package com.sc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.common.vo.PageObject;
import com.sc.dao.BuyerDao;
import com.sc.dao.MarketDao;
import com.sc.dao.RecordDao;
import com.sc.dao.SellerDao;
import com.sc.dao.StockDao;
import com.sc.pojo.Buyer;
import com.sc.pojo.Market;
import com.sc.pojo.Record;
import com.sc.pojo.Seller;
import com.sc.pojo.Stock;
import com.sc.pojo.User;
import com.sc.service.RecordService;
import com.sc.vo.RecordVo;

@Service
public class RecordServiceImpl implements RecordService {
	@Autowired
	RecordDao recordDao;
	@Autowired
	StockDao stockDao;
	@Autowired
	SellerDao sellerDao;
	@Autowired
	BuyerDao buyerDao;
	@Autowired
	MarketDao marketDao;

	@Override
	public int insertRecord(Market market, User user) {
		// 校验
		User seller = sellerDao.findUserBySellerId(market.getSeller_id());
		if (seller.getId() == user.getId())
			throw new IllegalAccessError("买家与卖家为同一人");
		// 市场中下架该商品
		marketDao.delete(market);
		// 删除卖家仓库中该道具
		stockDao.delete(market.getItem_id());
		// 添加买家仓库中该道具
		Stock stock = new Stock(user.getId(), market.getItem_id());
		stockDao.insert(stock);
		// 添加购买记录
		Buyer buyer = buyerDao.findBuyerByUserId(user.getId());
		Record record = new Record(buyer.getId(), market.getSeller_id(), market.getItem_id(), market.getPrice(),
				new Date());
		int row = recordDao.insertRecord(record);
		return row;
	}

	@Override
	public PageObject<RecordVo> findPageObjects(Integer sellerUser_id, Integer user_id, Long pageCurrent) {
		// 参数校验
		if (pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("当前页码值无效");
		// 判断查询对象与自身是否为同一人
		if (sellerUser_id != user_id)
			user_id = null;
		// 查询当前页记录
		int pageSize = 5;
		Buyer buyer = buyerDao.findBuyerByUserId(user_id);
		Seller seller = sellerDao.findSellerByUserId(sellerUser_id);
		long rowCount = recordDao.getRowCount(buyer.getId(), seller.getId());
		if (rowCount == 0)
			throw new IllegalArgumentException("无记录");
		long startIndex = (pageCurrent - 1) * pageSize;
		List<RecordVo> records = recordDao.findPageObjectByPrice(user_id, sellerUser_id, startIndex, pageSize);
		// 封装查询结果
		return new PageObject<>(records, rowCount, pageSize, pageCurrent);
	}

}
