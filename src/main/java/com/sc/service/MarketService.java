package com.sc.service;

import com.sc.common.vo.PageObject;
import com.sc.vo.MarketVo;

public interface MarketService {
	PageObject<MarketVo> findPageObject(Long pageCurrent, String type, String skin, String quality);
	
	PageObject<MarketVo> findPageObjectByPrice(Long pageCurrent);

}
