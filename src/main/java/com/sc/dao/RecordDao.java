package com.sc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sc.pojo.Record;
import com.sc.vo.RecordVo;

@Mapper
public interface RecordDao {
	int insertRecord(Record record);

	List<RecordVo> findPageObjectByPrice(Integer buyer_id, Integer seller_id, long startIndex, long pageSize);

	long getRowCount(Integer buyer_id, Integer seller_id);
}
