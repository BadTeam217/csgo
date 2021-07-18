package com.sc.controller;

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
	 * @param market
	 * @param user
	 * @return
	 */
	@RequestMapping("doInsertRecord")
	public JsonResult doInsertRecord(Market market, User user) {
		recordService.insertRecord(market, user);
		return new JsonResult("购买成功");
	}
}
