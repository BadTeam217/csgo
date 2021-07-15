package com.sc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sc.vo.UserItemVo;

@Mapper
public interface StockDao {
	/**
	 * 
	 * @param user_id
	 * @param startIndex
	 * @param pageSize
	 * @param type
	 * @param skin
	 * @param quality
	 * @return
	 */
	List<UserItemVo> findPageObject(Integer user_id, long startIndex, long pageSize, String type, String skin,
			String quality);
}
