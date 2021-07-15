package com.sc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomUserDetailsService userDetailsService;
	@Autowired
	AccessDeniedHandler accessDeniedHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf()
		.disable()
		.authorizeRequests()
		.antMatchers("/*").permitAll();
//		.hasAnyRole("USER")
//		.anyRequest()
//		.authenticated()
//		.and()
//		.formLogin()
//		.successForwardUrl("/doIndexUI")
//		.permitAll()
//		.and()
//		.logout()
//		.permitAll()
//		.and()
//		.exceptionHandling()
//		.accessDeniedHandler(accessDeniedHandler)

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
		web.ignoring()
				.antMatchers("/js/**")
				.antMatchers("/css/**");
	}

	@Bean
	PasswordEncoder setPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

}
