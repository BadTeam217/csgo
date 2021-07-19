package com.sc.dao;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sc.common.vo.PageObject;
import com.sc.pojo.Market;
import com.sc.service.MarketService;
import com.sc.vo.MarketVo;

@SpringBootTest
public class MarketDaoTest {
	@Autowired
	MarketDao marketDao;
	@Autowired
	MarketService service;

	@Test
	void insert() {
		System.out.println(marketDao.insert(new Market(1, 5, 400.32d, new Date())));
	}

	@Test
	void findItemsBySellerId() {
		System.out.println(marketDao.findItemsBySellerId(1));
	}

	@Test
	void findSellerByItemId() {
		System.out.println(marketDao.findSellerByItemId(2));
	}

	@Test
	public void testFindPageObject() {
		List<MarketVo> r = marketDao.findPageObject(0, 5);
		System.out.println(r);
	}

	@Test
	void findMarketBYItem() {
		System.out.println(marketDao.findMarketBYItem(1));
	}

	@Test
	void test() {
		PageObject<MarketVo> r = service.findPageObject(1L, "步枪", null, null);
		System.out.println(r);

	}
}
