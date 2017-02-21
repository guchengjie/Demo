package com.itany.bbs.rowmapper;

import java.sql.ResultSet;

import com.itany.bbs.entity.User;
import com.itany.jdbc.util.RowMapper;

public class UserRowmapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs) throws Exception {

		User user = new User();
		user.setUserid(rs.getInt("userid"));
		user.setLoginname(rs.getString("loginname"));
		user.setLoginpwd(rs.getString("loginpwd"));
		user.setEmail(rs.getString("email"));
		user.setHead(rs.getString("head"));
		user.setRegtime(rs.getDate("regtime"));
		user.setState(rs.getInt("state"));
		user.setPoint(rs.getInt("point"));
		user.setLevel(rs.getInt("level"));
		return user;

	}

}
