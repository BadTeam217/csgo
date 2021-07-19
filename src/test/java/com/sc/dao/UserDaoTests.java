package com.sc.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sc.pojo.User;

@SpringBootTest
public class UserDaoTests {
	@Autowired
	UserDao userDao;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Test
	public void testInsert() {
		User user = new User();
		user.setAccount("21703");
		user.setName("火红红");
		user.setPassword(new BCryptPasswordEncoder().encode("21703"));
		int result = userDao.insertObject(user);
		System.out.println(result);
	}

	@Test
	void insert() {
		User user = new User();
		user.setAccount("123456");
		user.setName("张三");
		user.setPassword(passwordEncoder.encode("123456"));
		userDao.insertObject(user);
		System.out.println(user);
	}

	@Test
	void findUserByAccount() {
		System.out.println(userDao.findUserByAccount("21704"));
	}

	@Test
	void testUpdate() {
		User user = new User(3, "水蓝蓝", passwordEncoder.encode("21702"), "21702");
		int r = userDao.updateObjectById(user);
		System.out.println(r);
	}
}
