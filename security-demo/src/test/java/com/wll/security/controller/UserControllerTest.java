package com.wll.security.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
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
    	String result =mockMvc.perform(get("/user")
    			.param("username", "pojo")
    			.param("age","2")
    			.param("xxx","yyy")
    			.param("ageTo","60")
//    			.param("size", "15")
//    			.param("page", "3")
//    			.param("sort", "age, desc")
    			.contentType(MediaType.APPLICATION_JSON_UTF8))
    			.andExpect(status().isOk())
    			.andExpect(jsonPath("$.length()").value(3))
    	        .andReturn().getResponse().getContentAsString();
    	
    	System.out.println(result);
    }
    
    
    @Test
    public void whenGetInfoSuccess() throws Exception {
    	String result=mockMvc.perform(get("/user/1")
    	       .contentType(MediaType.APPLICATION_JSON_UTF8))
    	       .andExpect(status().isOk())
    	       .andExpect(jsonPath("$.username").value("tom"))
    	       .andReturn().getResponse().getContentAsString();
    	
    	System.out.println(result);
    }
    
    @Test
    public void whenGetInfoFail() throws Exception {
    	mockMvc.perform(get("/user/a")
    	       .contentType(MediaType.APPLICATION_JSON_UTF8))
    	       .andExpect(status().is4xxClientError());
    }

    
    @Test
    public void  whenGreatSuccess() throws Exception {
    	
    	Date date=new Date();
    	
    	System.out.println("date: "+date.getTime());
    	
    	String content = "{\"username\":\"tom\",\"password\":\"null\",\"birthday\":"+date.getTime()+"}";
    	
    	String result=mockMvc.perform(MockMvcRequestBuilders.post("/user")
     	       .contentType(MediaType.APPLICATION_JSON_UTF8)
     	       .content(content))
    	       .andExpect(status().isOk())
    	       .andExpect(jsonPath("$.id").value(1))
    	       .andReturn().getResponse().getContentAsString();
     	     
    	System.out.println("result: "+result);
    }

}
