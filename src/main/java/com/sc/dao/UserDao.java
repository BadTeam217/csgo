package com.sc.dao;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sc.pojo.User;

@Mapper
public interface UserDao {
	@Select("select * from user where id=#{id}")
	User findObjectById(Integer id);

	@Select("select * from user where account=#{account}")
	Optional<User> findObjectByAccount(String account);

	int insertObject(User user);

	int updateObjectById(User user);

	@Select("select * from user where account=#{account}")
	User findUserByAccount(String account);
	
	@Select("select * from user where id=#{id}")
	User findUserByUserId(int id);
}
