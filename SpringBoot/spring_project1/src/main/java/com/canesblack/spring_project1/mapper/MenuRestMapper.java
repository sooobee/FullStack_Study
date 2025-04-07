package com.canesblack.spring_project1.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import com.canesblack.spring_project1.entity.Menu;

@Mapper
public interface MenuRestMapper {
	// 게시글 목록 가져오는 메서드
	@Select("SELECT idx, memID, title, content, writer, indate, count "
			+ "FROM backend_spring_project.menu ORDER BY idx DESC")
	public java.util.List<Menu>getLists();
	
	// 게시글 추가하는 메서드
	@Insert("INSERT INTO backend_spring_project.menu(memID, title, content, writer, indate) "
			+ "VALUES (#{memID}, #{title}, #{content}, #{writer}, #{indate})")
	public void boarderInsert(Menu menu);
	
	// 특정 게시글의 내용을 가져오는 메서드
	@Select("SELECT idx, memID, title, content, writer, indate, count "
			+ "FROM backend_spring_rpject.menu WHERE idx= #{idx}")
	public Menu boardContent(int idx);
	
	// 특정 게시글을 삭제하는 메서드
	@Delete("DELETE FROM backend_spring_project.menu WHERE idx=#{idx}")
	public void boardDelete(int idx);
	
	// 게시글 수정
	@Update("UPDATE backend_spring_project.menu SET title=#{title}, content=#{content}, writer=#{writer}")
	public void boardUpdate(Menu menu);
	
	// 조회수 업데이트
	@Update("UPDATE backend_spring_project.menu SET count = count+1 WHERE idx=#{idx}")
	public void boardCount(int idx);
}
