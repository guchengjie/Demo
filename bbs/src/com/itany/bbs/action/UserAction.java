package com.itany.bbs.action;

import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itany.bbs.entity.User;
import com.itany.bbs.service.UserService;
import com.itany.bbs.util.MD5Util;
import com.itany.factory.ObjectFactory;

public class UserAction {
	UserService service = (UserService) ObjectFactory.getObject("userservice");

	// 注册 action
	public String regist(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("utf-8");
		String loginname = request.getParameter("loginname");
		String loginpwd = request.getParameter("loginpwd");
		String md5pass = MD5Util.getMD5(loginpwd);
		String email = request.getParameter("email");
		String head = request.getParameter("head");
		java.util.Date date = new java.util.Date();
		Date regtime = new Date(date.getTime());
		int state = 1;
		int point = 0;
		int level = 0;
		// 没有进行ajax 异步验证
		// int id = this.service.findIdByUserName(loginname);
		// System.out.println(id);
		// System.out.println("id: "+id);
		// if(id>0){
		// request.setAttribute("checkname", id);
		// return "fail";
		// }

		User user = new User(null, loginname, md5pass, email, head, regtime,
				state, state,level);
		this.service.addUser(user);
		request.setAttribute("user", user);
		System.out.println("zhuce: " + user.getLoginname());
		return "success";

	}

	// 验证用户名是否存在
	public void validUserName(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("utf-8");
		String uname = request.getParameter("name");
		// String ret="false";
		// uname=URLDecoder.decode(uname,"UTF-8");
		// int id = service.findIdByUserName(uname);
		// if(id>0){
		// ret="true";
		// }
		// response.setContentType("text/plain");
		// PrintWriter out = response.getWriter();
		// out.print(ret);
		// out.flush();
		// out.close();

		String ret = "false";
		uname = URLDecoder.decode(uname, "UTF_8");
		int id = this.service.findIdByUserName(uname);
		if (id > 0) {
			ret = "true";
		}
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.print(ret);
		out.flush();
		out.close();
	}


	// 登录action
	public String login(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession(true);
		response.setHeader("content-type", "text/html;charset=utf-8");
		String username = request.getParameter("loginname");
		String password = request.getParameter("loginpwd");
		String passwords = MD5Util.getMD5(password);
		String vcode = request.getParameter("vcode");

		// 验证码判断
		String code = (String) session.getAttribute("code");
		System.out.println(code);
		if (!(code.equalsIgnoreCase(vcode))) {
			request.setAttribute("loginrr", "验证码错误");
			return "fail";
		}
		// 判断用户 密码是否正确
		User user = service.isValidUser(username, passwords);
        if(user != null){
            session.setAttribute("users", user);
            return "success";
        }
        request.setAttribute("loginrr", "您未注册，请注册后再登录");
        return "fail";
		

	}



	// 安全退出
	public String exit(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.getSession().invalidate();
		return "success";
	}

	// 修改密碼
	public String email(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession(true);

		String loginname = request.getParameter("loginname");
		String email = request.getParameter("email");

		boolean state = service.findLoginPwd(loginname, email);

		if (state == false) {
			request.setAttribute("error", "找回失败");
			return "fail";
		}

		return "success";

	}

}
