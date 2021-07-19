package com.sc.controller;

import com.sc.pojo.Market;
import com.sc.util.ResponseMsgUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sc.common.vo.JsonResult;
import com.sc.common.vo.PageObject;
import com.sc.service.MarketService;
import com.sc.vo.MarketVo;

@RestController
@RequestMapping("/market/")
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
	@RequestMapping("doFindPageObjects")
	public JsonResult doFindPageObjects(Long pageCurrent, String type, String skin, String quality) {
		PageObject<MarketVo> result = marketService.findPageObject(pageCurrent, type, skin, quality);
		return new JsonResult(result);
	}

	@PostMapping("doPutOnShelf")
	public String putOnShelf(Market market) {
		int result = marketService.putOnShelf(market);
		String r = null;
		if (result == -1) {
			r = ResponseMsgUtil.getResult("NotExist");
		} else
			r = ResponseMsgUtil.getResult(result);
		return r;
	}

	@PostMapping("doOffShelf")
	public String offShelf(Market market) {
		int result = marketService.offShelf(market);
		String r = null;
		if (result == -1) {
			r = ResponseMsgUtil.getResult("NotExist");
		} else
			r = ResponseMsgUtil.getResult(result);
		return r;
	}

	@RequestMapping("doFindPageObjectsOnShelf")
	public JsonResult doFindPageObjectsOnShelf(Integer user_id, Long pageCurrent) {
		PageObject<MarketVo> result = marketService.findPageObjectsOnShelf(user_id, pageCurrent);
		return new JsonResult(result);
	}

	/**
	 * 修改价格
	 * 
	 * @param user_id 商品所属用户的id
	 * @param item_id 待修改商品的id
	 * @param price   修改后的价格
	 * @return
	 */
	@RequestMapping("/doUpdatePriceByKey")
	public JsonResult doUpdatePriceByKey(Integer user_id, Integer item_id, Double price) {
		marketService.updatePriceByKey(user_id, item_id, price);
		return new JsonResult("修改成功！");
	}
}