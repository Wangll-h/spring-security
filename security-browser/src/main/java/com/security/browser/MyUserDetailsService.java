//package com.security.browser;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MyUserDetailsService implements UserDetailsService {
//
//    private Logger log = LoggerFactory.getLogger(MyUserDetailsService.class);
//    
//    private PasswordEncoder passswordEncoder;
//    
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         //根据用户名查找用户信息
//        log.info("登录用户名："+username);
//        //根据查找到的信息判断用户是否过期
//        return new User(username,"123456", 
//                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
//    }
//    
//  
//}
