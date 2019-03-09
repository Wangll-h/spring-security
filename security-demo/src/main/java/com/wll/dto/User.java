package com.wll.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonView;

public class User{
	
	public interface UserImpleView {};
	
	public interface UserDetailView extends UserImpleView{};
	
	private String id;
	
	private String username;
	
	private String password;
	
	private Date birthday;

	@JsonView(UserImpleView.class)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonView(UserDetailView.class)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	@JsonView(UserImpleView.class)
	public void setId(String id) {
		this.id = id;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


}
