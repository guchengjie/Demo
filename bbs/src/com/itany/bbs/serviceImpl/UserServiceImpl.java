package com.itany.bbs.serviceImpl;

import com.itany.bbs.dao.UserDao;
import com.itany.bbs.entity.User;
import com.itany.bbs.service.UserService;
import com.itany.bbs.util.MD5Util;
import com.itany.bbs.util.MailSender;
import com.itany.bbs.util.PwdMaker;
import com.itany.factory.ObjectFactory;

public class UserServiceImpl implements UserService {

	UserDao dao = (UserDao) ObjectFactory.getObject("userdao");

	@Override
	// 用于登录时验证用户：验证成功返回存放用户信息的User对象，否则返回null
	public User isValidUser(String name, String pass) {
		return this.dao.isValidUser(name, pass);
	}

	@Override
	public int addUser(User user) {
		// 添加用户，用于注册
		return this.dao.addUser(user);
	}

	@Override
	public int findIdByUserName(String name) {
		// 验证用户名是否存在：如存在返回该用户id
		return this.dao.findIdByUserName(name);
	}

	@Override
	public boolean findLoginPwd(String loginname, String email) {
		// 核对信息，发送找回密码邮件

		User user = this.dao.findUserByEmail(loginname, email);

		if (null == user) {
			return false;
		}

		String newpass = PwdMaker.getRandomString(6);

		String md5 = MD5Util.getMD5(newpass);

		user.setLoginpwd(md5);

		dao.modifyLoginPwd(user);

		return MailSender.sendMail(email, newpass, loginname);
	}

	@Override
	public int findIdByEmail(String email) {

		return this.dao.findIdByEmail(email);
	}

}
