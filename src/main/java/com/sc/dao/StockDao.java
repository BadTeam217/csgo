package com.sc.dao;

import java.util.List;

import com.sc.pojo.Stock;
import org.apache.ibatis.annotations.Mapper;

import com.sc.vo.UserItemVo;

@Mapper
public interface StockDao {
	/**
	 * 
	 * @param user_id
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<UserItemVo> findPageObject(Integer user_id, long startIndex, long pageSize);

	public int insert(Stock stock);

	public int delete(Integer id);
}
