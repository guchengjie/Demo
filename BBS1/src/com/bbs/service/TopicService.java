package com.bbs.service;

import java.util.List;

import com.bbs.entity.Topic;

public interface TopicService {
	
	public List<Topic> findAll(Integer pagenumber,Integer pagesize);
	
	public Integer total();
	
	public Integer addtop(Integer id,Integer zx);
	
	public Integer addgood(Integer id,Integer zx);
	
	public Topic addmodify(Integer id);
	
	public Integer adddelet(Integer id);
	
	public Integer addchange(Topic ti);
}
