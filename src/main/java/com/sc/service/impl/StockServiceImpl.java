package com.sc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.common.vo.PageObject;
import com.sc.dao.StockDao;
import com.sc.service.StockService;
import com.sc.vo.UserItemVo;

@Service
public class StockServiceImpl implements StockService {
	@Autowired
	StockDao stockDao;

	@Override
	public PageObject<UserItemVo> findPageObjects(Integer user_id, Long pageCurrent, String type, String skin,
			String quality) {
		// 参数校验
		if (pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("当前页码值无效");
		// 查询当前页记录
		int pageSize = 5;
		long startIndex = (pageCurrent - 1) * pageSize;
		List<UserItemVo> results = stockDao.findPageObject(user_id, startIndex, pageSize);
		List<UserItemVo> records = new ArrayList<>();
		for (UserItemVo r : results) {
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
		long rowCount = records.size();
		// 封装查询结果
		return new PageObject<>(records, rowCount, pageSize, pageCurrent);

	}

}
