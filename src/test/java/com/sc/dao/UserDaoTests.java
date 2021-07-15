package com.sc.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sc.pojo.User;

@SpringBootTest
public class UserDaoTests {
	@Autowired
	UserDao userDao;

	@Test
	public void testInsert() {
		User user = new User();
		user.setAccount("21703");
		user.setName("火红红");
		user.setPassword(new BCryptPasswordEncoder().encode("21703"));
		int result = userDao.insertObject(user);
		System.out.println(result);
	}
}
