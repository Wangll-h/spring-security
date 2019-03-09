package com.wll.web.controller;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.wll.dto.User;
import com.wll.dto.UserQueryCondition;
import com.wll.exception.UserNotFoundException;
import com.wll.dto.User.UserImpleView;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		
		//throw new UserNotFoundException();
		
		System.out.println(user.getUsername());
		System.out.println(user.getBirthday());
		user.setId("1");
		return user;
	}
	
	@GetMapping
	@JsonView(UserImpleView.class)
	public List<User> query(UserQueryCondition condition,@PageableDefault(page=2, size=17, sort="username,asc")Pageable page) {
		
		System.out.println(ReflectionToStringBuilder.toString(condition));
		System.out.println(page.getPageNumber());
		System.out.println(page.getPageSize());
		System.out.println(page.getSort());
		List<User> users=new ArrayList(3);
		users.add(new User());
		users.add(new User());
		users.add(new User());
		
		return users;
	}

	@GetMapping(value = "/{id:\\d+}" )
	public User getInfo(@PathVariable String id) {
		System.out.println("进入getinfo");
		User user = new User();
		user.setUsername("tom");
		return user;
	}
}
