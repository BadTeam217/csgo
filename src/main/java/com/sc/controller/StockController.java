package com.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sc.common.vo.JsonResult;
import com.sc.common.vo.PageObject;
import com.sc.service.StockService;
import com.sc.vo.UserItemVo;

@RestController
@RequestMapping("/stock")
public class StockController {
	@Autowired
	private StockService stockService;

	@RequestMapping("doFindPageObjects")
	public JsonResult doFindPageObjects(Integer user_id, Long pageCurrent, String type, String skin, String quality) {
		PageObject<UserItemVo> result = stockService.findPageObjects(user_id, pageCurrent, type, skin, quality);
		return new JsonResult(result);
	}

}
