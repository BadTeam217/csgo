package com.sc.dao;

import com.sc.pojo.Market;
import com.sc.vo.MarketVo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class MarketDaoTest {
	@Autowired
	MarketDao marketDao;

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
}
