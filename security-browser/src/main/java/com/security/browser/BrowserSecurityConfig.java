package com.security.browser;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.formLogin()
		     .and()
		     .authorizeRequests()
		     .anyRequest()
		     .authenticated();
	}
	
	 @Bean
	 public PasswordEncoder passwordEncoder() { 
		 return new BCryptPasswordEncoder(); 
		 } 
	 
	 
	 @Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
		 auth.inMemoryAuthentication() .passwordEncoder(passwordEncoder()) 
		     .withUser("qin").password(passwordEncoder().encode("111"))
		     .roles("USER") .and() .withUser("kai").password(passwordEncoder()
		     .encode("222")).roles("USER"); 
	}
	
}
