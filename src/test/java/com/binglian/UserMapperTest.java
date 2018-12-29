package com.binglian;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.binglian.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void find(){
		String password=userMapper.getUserPassword("123456");
		System.out.println("密码是："+password);
	}
	
	@Test
	public void findRolse(){
		String rolse=userMapper.getUserRolse("123456");
		System.out.println("角色："+rolse);
	}
}
