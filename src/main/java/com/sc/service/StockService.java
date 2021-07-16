package com.sc.service;

import com.sc.common.vo.PageObject;
import com.sc.vo.UserItemVo;

public interface StockService {
	PageObject<UserItemVo> findPageObjects(Integer user_id, Long pageCurrent, String type, String skin, String quality);

}
