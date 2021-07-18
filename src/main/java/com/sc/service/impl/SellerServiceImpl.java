package com.sc.service.impl;

import com.sc.dao.SellerDao;
import com.sc.service.SellerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	SellerDao sellerDao;
	
	@Override
	public int doFindSellerId(int user_id) {
		return sellerDao.findSellerIdByIuserId(user_id);
	}
}
