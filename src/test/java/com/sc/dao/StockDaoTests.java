package com.sc.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sc.vo.UserItemVo;

@SpringBootTest
public class StockDaoTests {
	@Autowired
	private StockDao stockDao;

	@Test
	public void testFindPageObject() {
		List<UserItemVo> r = stockDao.findPageObject(1, 0, 2);
		System.out.println(r);
	}

	@Test
	public void testGetRowCount() {
		long r = stockDao.getRowCount(1);
		System.out.println(r);
	}
}
