package com.sc.security;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sc.dao.ItemDao;
import com.sc.dao.UserDao;
import com.sc.pojo.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	UserDao userDao;

	@Autowired
	HttpSession session;

	@Override
	public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
		Optional<User> optUser = userDao.findObjectByAccount(account);
		User user = optUser.orElseThrow(() -> {
			throw new UsernameNotFoundException("User not Found!");// optUser值为空时抛出异常
		});
		session.setAttribute("USER", user);
		return new CustomUserDetails(user);
	}

}
