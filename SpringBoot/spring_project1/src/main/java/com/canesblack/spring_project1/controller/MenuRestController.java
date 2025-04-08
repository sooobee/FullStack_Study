package com.canesblack.spring_project1.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.canesblack.spring_project1.entity.Menu;
import com.canesblack.spring_project1.service.MenuRestService;


@RestController
public class MenuRestController {
	
	// 게시판 통신 관련 controller
	@Autowired
	private MenuRestService menuRestService;
	
	//1. 게시판 조회(모든 게시글을 불러옴)
	// 백 -> 프론트 단으로 데이터 넘길 때
	//상태코드 200번대 여야 데이터가 이동할 수 있음(ok 역할) 
	@GetMapping("/menu/all")
	public ResponseEntity<List<Menu>> getAllMenus(){
		List<Menu>menus = menuRestService.getLists();
		
		// 게시글이 있을 때
		if(menus != null && !menus.isEmpty()) {
			return ResponseEntity.ok(menus);
		} else {
			// 상태코드 204번: 데이터가 없다는 의미 (NoContent)
			return ResponseEntity.noContent().build();
		}
	}
	// 2. 게시판 생성
	// 프론트 -> 백으로 데이터 넘김
	@PostMapping("/menu/add")
	public ResponseEntity<String> addMenu(@RequestBody Menu menu){
		
		
		// 날짜를 입력안해줬을 때 백엔드에서 직접 작성함
		if(menu.getIndate() == null || menu.getIndate().isEmpty()) {
			menu.setIndate(LocalDate.now().toString()); // 현재 날짜로 설정
		} 
		
		menu.setCount(0); // 조회수 초깃값 0 설정
		menuRestService.boardInsert(menu); //게시물을 DB에 추가
		
		return ResponseEntity.ok("게시글이 잘 작성되었습니다.");
	}
	
	// 3. 게시글 수정
	@PutMapping("/menu/update/{idx}")
	public void updateMenu(@RequestBody Menu menu, @PathVariable("idx") int idx){
		
		menu.setIdx(idx); // idx 세팅 -> 이 게시글에 접근
		menuRestService.boardUpdate(menu); // 게시글 수
	}
	
	// 4.게시글 삭제
	@DeleteMapping("/menu/delete/{idx}")
	public void deleteMenu(@PathVariable("idx") int idx) {
		menuRestService.boardDelete(idx);
	}
	
	// 5. 특정 게시글 1개 조회
	@GetMapping("menu/{idx}")
	public ResponseEntity<Menu>getMenuById(@PathVariable("idx") int idx){
		Menu menu = menuRestService.boardContent(idx);
		
		if(menu != null) {
			return ResponseEntity.ok(menu); // 200번대 상태코드와 menu 객체를 백-> 프론트로 넘김
		} else {
			return ResponseEntity.notFound().build(); // 메뉴 존재 안할때 404에러 반환
		}
	}
	
	//6.특정 게시글 조회수 증가
	@PutMapping("menu/count/{idx}")
	public void incrementMenuCount(@PathVariable("idx") int idx) {
		menuRestService.boardCount(idx); // 게시판 조회수 + 1
	}
}


