package com.canesblack.spring_project1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canesblack.spring_project1.entity.Menu;
import com.canesblack.spring_project1.mapper.MenuRestMapper;

@Service
public class MenuRestService {
	
	@Autowired
	private MenuRestMapper menuRestMapper;
	
	// 게시글 목록을 가져오는 메서드
	public List<Menu>getLists(){
		return menuRestMapper.getLists();
	}
	
	// 게시글을 추가하는 메서드
	public void boardInsert(Menu menu){
		menuRestMapper.boarderInsert(menu);
	}
	
	// 특정 게시글의 내용을 가져오는 메서드
	public Menu boardContent(int idx) {
		return menuRestMapper.boardContent(idx);
	}
	
	// 특정 게시글을 삭제하는 메서드 
	public void boardDelete(int idx) {
		menuRestMapper.boardDelete(idx);
	}
	
	// 특정 게시글을 수정하는 메서드 
	public void boardUpdate(Menu menu) {
		menuRestMapper.boardUpdate(menu);
	}
	
	// 조회수를 증가 시키는 메서드 
	public void boardCount(int idx) {
		menuRestMapper.boardCount(idx);
	}
	
}
