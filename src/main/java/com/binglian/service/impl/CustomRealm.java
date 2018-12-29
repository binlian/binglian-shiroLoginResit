package com.binglian.service.impl;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.binglian.service.UserService;

public class CustomRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;
	
	/**
	 * 授权管理
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		//从主体获取用户
		String username=(String)principals.getPrimaryPrincipal();
		
		//从数据库查询用户的角色
		String rolse=userService.queryRolse(username);
		SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addRole(rolse);
		return simpleAuthorizationInfo;
	}
	

	/**
	 * 认证信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		//从主体获取传过来的用户
		String username=(String)token.getPrincipal();
		
		//通过用户传过来从数据库进行密码
		String password=userService.loginPassword(username);
		
		if(password == null){
			return null;
		}
		//加盐
		ByteSource salt = ByteSource.Util.bytes(username);
        String realmName = this.getName();//获取当前自定义的realm
        
		SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(username, password, salt, realmName);
		return simpleAuthenticationInfo;
	}

}
