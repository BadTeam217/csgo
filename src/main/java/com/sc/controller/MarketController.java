package com.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sc.common.vo.JsonResult;
import com.sc.common.vo.PageObject;
import com.sc.service.MarketService;
import com.sc.vo.MarketVo;

@RestController
@RequestMapping("/Market")
public class MarketController {
	@Autowired
	private MarketService marketService;

	/**
	 * 查询页面对象（浏览）
	 * 
	 * @param pageCurrent 当前页码值
	 * @param type
	 * @param skin
	 * @param quality
	 * @return
	 */
	public JsonResult doFindPageObjects(Long pageCurrent, String type, String skin, String quality) {
		PageObject<MarketVo> result = marketService.findPageObject(pageCurrent, type, skin, quality);
		return new JsonResult(result);
	}
}