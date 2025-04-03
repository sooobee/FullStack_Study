package com.canesblack.spring_project1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.canesblack.spring_project1.entity.CustomUser;
import com.canesblack.spring_project1.entity.User;
import com.canesblack.spring_project1.mapper.UserMapper;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user = userMapper.findByUsername(username);
		
		if(user == null) {
			//데이터 없을 시 예외 처리 
			throw new UsernameNotFoundException(username + "존재하지 않습니다.");
		} 
		
		// 유저정보가 DB에 존재할 시 
		return new CustomUser(user);
	}
}
