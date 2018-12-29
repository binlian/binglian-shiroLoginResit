package com.binglian.service;

public interface UserService {

	/**
	 * 根据username 查询密码
	 * @param username
	 * @return
	 */
	String loginPassword(String username);

	/**
	 * 根据username查询角色
	 * @param username
	 * @return
	 */
	String queryRolse(String username);

	/**
	 * 注册
	 * @param username
	 * @param password
	 */
	void regist(String username,String password);
}
