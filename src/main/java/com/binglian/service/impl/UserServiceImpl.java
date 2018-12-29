package com.binglian.service.impl;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binglian.mapper.UserMapper;
import com.binglian.pojo.User;
import com.binglian.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public String loginPassword(String username) {
		String password=userMapper.getUserPassword(username);
		return password;
	}

	@Override
	public String queryRolse(String username) {
		String rolse=userMapper.getUserRolse(username);
		return rolse;
	}

	@Override
	public void regist(String username, String password) {
		User user=new User();
		// 将用户名作为盐值 
		ByteSource salt = ByteSource.Util.bytes(username); 
		
		String newpassword = new SimpleHash("MD5", password, salt, 1024).toHex();
		user.setId(null);
		user.setPassword(newpassword);
		user.setUsername(username);
		user.setRolse("admin");
		userMapper.insert(user);
	}

}
