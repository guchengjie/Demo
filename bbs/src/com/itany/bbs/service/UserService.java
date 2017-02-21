package com.itany.bbs.service;

import com.itany.bbs.entity.User;

public interface UserService {
	/**
	 * 用于登录时验证用户：验证成功返回存放用户信息的User对象，否则返回null
	 * 
	 * @param name
	 *            用户名
	 * @param pass
	 *            密码
	 * @return User对象或null
	 */
	User isValidUser(String name, String pass);

	/**
	 * 添加用户，用于注册
	 * 
	 * @param user
	 * @return 新注册用户id
	 */
	int addUser(User user);

	/**
	 * 验证用户名是否存在：如存在返回该用户id
	 * 
	 * @param name
	 *            用户名
	 * @return 大于0-存在，0-不存在
	 */
	int findIdByUserName(String name);
	   /**
     * 
     * 核对信息，发送找回密码邮件
     * 
     * @param loginname 登录名
     * @param email email
     * @return 信息核对成功返回true
     */
	public boolean findLoginPwd(String loginname,String email);

	/**
	 * 验证邮箱是否存在：如存在返回该用户id
	 * 
	 * @param name
	 *            用户名
	 * @return 大于0-存在，0-不存在
	 */
	int findIdByEmail(String email) ;
}
