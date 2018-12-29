package com.binglian.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.binglian.service.UserService;

@Controller
public class UserController {

	
	@Autowired
	private UserService userService;

	
	@RequestMapping("/login")
	@ResponseBody
	public String login(@RequestParam("username") String username,
						@RequestParam("password") String password){
		Subject subject=SecurityUtils.getSubject();
		
		UsernamePasswordToken token=new UsernamePasswordToken(username, password);
		
		try {
			subject.login(token);
			if (subject.isAuthenticated()==true) {
				System.out.println("成功");
			}
		} catch (AuthenticationException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		if (subject.hasRole("admin")) {
			return "admin权限";
		}
		
		return "无admin";
	}
	
	@RequestMapping("/regist")
	@ResponseBody
	public String regist(@RequestParam("username") String username,
						@RequestParam("password") String password){
		userService.regist(username, password);
		
		return "注册成功";
	}
	
	@RequestMapping("/list")
	public String list(){
		
		return "list";
	}
	
	@RequiresRoles("admin")
	@RequestMapping("/add")
	@ResponseBody
	public String add(){
		
		return "admin";
		
	}
	@RequiresRoles("user")
	@RequestMapping("/add1")
	@ResponseBody
	public String add1(){
		
		return "用户";
		
	}
	
	@RequestMapping("/regist1")
	public String registindex(){
		return "regist";
	}
	
	@RequestMapping("/login1")
	public String loginindex(){
		return "login";
	}
}
