package com.sc.service.impl;

import java.util.ArrayList;
import java.util.List;

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

}
