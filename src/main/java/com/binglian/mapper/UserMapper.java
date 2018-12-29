package com.binglian.mapper;

import com.binglian.pojo.User;
import com.binglian.utils.MyMapper;

public interface UserMapper extends MyMapper<User> {
	
	//根据username返回password
	String getUserPassword(String username);
	
	//根据username返回rolse
	String getUserRolse(String username);
}