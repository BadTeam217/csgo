package com.sc.controller;

import com.sc.common.vo.PageObject;
import com.sc.vo.RecordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sc.common.vo.JsonResult;
import com.sc.pojo.Market;
import com.sc.pojo.User;
import com.sc.service.RecordService;

@RestController
@RequestMapping("/record/")
public class RecordController {
	@Autowired
	private RecordService recordService;

	/**
	 * 购买
	 * 
	 * @param market
	 * @param user
	 * @return
	 */
	@RequestMapping("doInsertRecord")
	public JsonResult doInsertRecord(Market market, User user) {
		recordService.insertRecord(market, user);
		return new JsonResult("购买成功");
	}

	/**
	 * 查询交易记录
	 * 
	 * @param sellerUser_id 被查询者的user_id
	 * @param user_id       查询发起者的user_id，即当前登录对象的user_id
	 * @param pageCurrent
	 * @return
	 */
	@RequestMapping("/doFindPageObjects")
	public JsonResult doFindPageObjects(Integer sellerUser_id, Integer user_id, Long pageCurrent) {
		PageObject<RecordVo> result = recordService.findPageObjects(sellerUser_id, user_id, pageCurrent);
		return new JsonResult(result);
	}
}
