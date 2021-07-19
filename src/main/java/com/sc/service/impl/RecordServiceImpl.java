package com.sc.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.dao.BuyerDao;
import com.sc.dao.MarketDao;
import com.sc.dao.RecordDao;
import com.sc.dao.SellerDao;
import com.sc.dao.StockDao;
import com.sc.pojo.Buyer;
import com.sc.pojo.Market;
import com.sc.pojo.Stock;
import com.sc.pojo.User;
import com.sc.pojo.Record;
import com.sc.service.RecordService;

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
	
	
}
