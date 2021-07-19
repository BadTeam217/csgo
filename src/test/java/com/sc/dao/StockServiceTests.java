package com.sc.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sc.common.vo.PageObject;
import com.sc.service.StockService;
import com.sc.vo.UserItemVo;

@SpringBootTest
public class StockServiceTests {
	@Autowired
	private StockService stockService;
}
