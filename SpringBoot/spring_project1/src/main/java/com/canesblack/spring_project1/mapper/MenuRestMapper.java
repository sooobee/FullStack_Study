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
	@Select("SELECT idx, memID, title, content, write, indate, count "
			+ "FROM backend_spring_project.menu ORDER BY idx DESC")
	public java.util.List<Menu>getLists();
	
	
	@Insert("INSERT INTO backend_spring_project.menu(memID, title, content, writer, indate) "
			+ "VALUES (#{memID}, #{title}, #{content}, #{writer}, #{indate})")
	public void boarderInsert(Menu menu);
	
	
	@Select("SELECT idx, memID, title, content, write, indate, count "
			+ "FROM backend_spring_rpject.menu WHERE idx= #{idx}")
	public Menu boardContent(int idx);
	
	@Delete("DELETE FROM backend_spring_project.menu WHERE idx=#{idx}")
	public void boardDelete(int idx);
	
	// 게시글 수정
	@Update("UPDATE backend_spring_project.menu SET title=#{title}, content=#{content}, writer=#{writer}")
	public void boardUpdate(Menu menu);
	
	// 조회수 업데이트
	@Update("UPDATE backend_spring_project.menu SET count = count+1 WHERE idx=#{idx}")
	public void boardCount(int idx);
}
