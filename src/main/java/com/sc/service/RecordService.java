package com.sc.service;

import com.sc.common.vo.PageObject;
import com.sc.pojo.Market;
import com.sc.pojo.User;
import com.sc.vo.RecordVo;

public interface RecordService {
	int insertRecord(Integer sellerUser_id, Integer buyerUser_id, Integer item_id);

	PageObject<RecordVo> findPageObjects(Integer sellerUser_id, Integer user_id, Long pageCurrent);
}
