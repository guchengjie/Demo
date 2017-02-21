package com.bbs.service;

import java.util.List;

import com.bbs.entity.Topic;

public interface TopicService {
	
	public List<Topic> findAll(Integer pagenumber, Integer pagesize);
	
	public Integer total();
}
