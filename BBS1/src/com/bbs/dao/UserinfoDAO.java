package com.bbs.dao;

import java.sql.SQLException;
import java.util.List;

import com.bbs.entity.Userinfo;

public interface UserinfoDAO {
	
	public Userinfo findByUserid() throws SQLException;
}
