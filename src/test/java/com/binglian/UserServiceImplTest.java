package com.binglian;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.binglian.service.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Test
	public void findPassword(){
		String password=userServiceImpl.loginPassword("123456");
		System.out.println(password);
	}
	
	@Test
	public void findRolse(){
		String rolse=userServiceImpl.queryRolse("123456");
		System.out.println(rolse);
	}
	
	@Test
	public void Regist(){
		userServiceImpl.regist("admin", "123456");
	}
}
