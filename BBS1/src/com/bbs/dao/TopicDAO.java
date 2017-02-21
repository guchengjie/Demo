package com.bbs.dao;

import java.sql.SQLException;
import java.util.List;

import com.bbs.entity.Topic;

public interface TopicDAO {

	public List<Topic> findAll(Integer pagenumber,Integer pagesize) throws SQLException;
	
	public Integer total() throws SQLException;
	
	public Integer addtop(Integer id,Integer zx) throws SQLException;
	
	public Integer addgood(Integer id,Integer zx) throws SQLException;
	
	public Topic addmodify(Integer id) throws SQLException;
	
	public Integer adddelet(Integer id) throws SQLException;
	
	public Integer addchange(Topic ti) throws SQLException;
}
