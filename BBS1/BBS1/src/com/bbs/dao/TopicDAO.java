package com.bbs.dao;

import java.sql.SQLException;
import java.util.List;

import com.bbs.entity.Topic;

public interface TopicDAO {

	public List<Topic> findAll(Integer pagenumber, Integer pagesize) throws SQLException;
	
	public Integer total() throws SQLException;
}
