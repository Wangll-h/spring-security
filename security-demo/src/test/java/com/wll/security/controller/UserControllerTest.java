package com.wll.security.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

	@Autowired
    private WebApplicationContext mvc;
	
	private MockMvc mockMvc;
	
    @Before
    public void setUp() {
    	mockMvc = MockMvcBuilders.webAppContextSetup(mvc).build();
    }
    
    @Test
    public void whenQuerySuccess() throws Exception {
    	mockMvc.perform(get("/user")
    			.param("username", "pojo")
    			.param("age","2")
    			.param("xxx","yyy")
    			.param("ageTo","60")
//    			.param("size", "15")
//    			.param("page", "3")
//    			.param("sort", "age, desc")
    			.contentType(MediaType.APPLICATION_JSON_UTF8))
    			.andExpect(status().isOk())
    			.andExpect(jsonPath("$.length()").value(3));
    }
    
    

}
