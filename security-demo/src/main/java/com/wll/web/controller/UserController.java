package com.wll.web.controller;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wll.dto.User;
import com.wll.dto.UserQueryCondition;

@RestController
public class UserController {
	
	@RequestMapping(value = "/user" , method = RequestMethod.GET)
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

}
