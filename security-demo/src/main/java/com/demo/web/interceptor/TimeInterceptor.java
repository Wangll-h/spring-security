package com.demo.web.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TimeInterceptor implements HandlerInterceptor{

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
        System.out.println("interceptor preHandler");
        
        System.out.println("intercecptor: "+((HandlerMethod) handler).getBean().getClass().getName());
        System.out.println("intercecptor: "+((HandlerMethod) handler).getMethod().getName());
        
        request.setAttribute("startTime", new Date().getTime());
        return true;
	}

	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			 ModelAndView modelAndView) throws Exception {
		  System.out.println("intercecptor postHandler");
		  
		  Long start = (Long)request.getAttribute("startTime");
		  System.out.println(" time inteceptor postHandler耗时: "+(new Date().getTime()-start));
	}

	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			 Exception ex) throws Exception {
		  System.out.println("intercecptor afterCompletion");
		  Long start = (Long)request.getAttribute("startTime");
		  System.out.println("time inteceptor afterCompletion 耗时: "+(new Date().getTime()-start));
	      //System.out.println("intercecptor ex is "+ex.getMessage());
	}
}
