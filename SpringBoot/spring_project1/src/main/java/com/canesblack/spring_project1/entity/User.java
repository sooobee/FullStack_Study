package com.canesblack.spring_project1.entity;

// MVC의 Model 영역에 해당
public class User {
	private int idx;
	private String username;
	private String password;
	private String wirter;
	private Role role;
	
	public User() {}
	
	// 생성자
	public User(int idx, String username, String password, String wirter, Role role) {
		this.idx = idx;
		this.username = username;
		this.password = password;
		this.wirter = wirter;
		this.role = role;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWirter() {
		return wirter;
	}

	public void setWirter(String wirter) {
		this.wirter = wirter;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
