package com.sc.dao;

import org.apache.ibatis.annotations.Mapper;
import com.sc.pojo.Record;

@Mapper
public interface RecordDao {
	int insertRecord(Record record);
}
