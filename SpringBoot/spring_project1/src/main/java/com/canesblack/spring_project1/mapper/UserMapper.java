package com.canesblack.spring_project1.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;

import com.canesblack.spring_project1.entity.User;

@Mapper
public interface UserMapper {
	
	// CRUD에 해당하는 기능(Read, Create, update, delete)
	// create
	@Insert("INSERT INTO backend_spring_project.user(username,password,writer,role)"
			+ " VALUES(#{username},#{password},#{writer},#{role})")
	void insertUser(User user); // 사용 함수
	
	// read
	@Select("SELECT username,password,writer,role FROM backend_spring_project.user WHERE username=#{username}")
	User findByUsername(String username); // username 가지고 옴 
	 
	@Select("SELECT writer FROM backend_spring_project.user WHERE username=#{username}")
	String findWriter(String username); // writer 가져옴
	
//	@Update()
//	@Delete()

}

