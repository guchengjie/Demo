package com.bbs.rowmapper;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import com.bbs.entity.Userinfo;
import com.bbs.util.DateHelper;
import com.itany.jdbc.util.RowMapper;

public class UserinfoRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs) throws Exception {
		
		Userinfo user = new Userinfo();
		user.setUserid(rs.getInt("userid"));
		user.setLoginname(rs.getString("loginname"));
		user.setLoginpwd(rs.getString("loginpwd"));
	
		user.setRegtime(DateHelper.fromDateToString(rs.getTimestamp("regtime")));
		
		user.setHead(rs.getString("head"));
		user.setEmail(rs.getString("email"));
		user.setState(rs.getInt("state"));
		user.setPoint(rs.getInt("point"));
		
		return user;
	}

}
