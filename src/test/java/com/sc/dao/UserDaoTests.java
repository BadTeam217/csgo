package com.sc.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sc.pojo.User;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class UserDaoTests {
	@Autowired
	UserDao userDao;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Test
	public void testInsert() {
		User user = new User();
		user.setAccount("21704");
		user.setName("欧金金");
		user.setPassword(new BCryptPasswordEncoder().encode("21704"));
		int result = userDao.insertObject(user);
		System.out.println(result);
	}
	@Test
	void insert(){
		User user = new User();
		user.setAccount("123456");
		user.setName("张三");
		user.setPassword(passwordEncoder.encode("123456"));
		userDao.insertObject(user);
		System.out.println(user);
	}
}
