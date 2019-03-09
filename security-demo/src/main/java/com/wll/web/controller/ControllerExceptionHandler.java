package com.wll.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wll.exception.UserNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {

	  @ExceptionHandler(UserNotFoundException.class)
	  @ResponseBody
	  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
      public Map<String,Object> handleUserNotExsitException(UserNotFoundException ex){
    	  Map<String,Object> result = new HashMap();
    	  result.put("id",ex.getId());
    	  result.put("message",ex.getMessage());
		  return result;
      }
}
