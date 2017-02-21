package com.bbs.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import com.bbs.dao.TopicDAO;
import com.bbs.entity.Topic;
import com.bbs.service.TopicService;
import com.itany.factory.ObjectFactory;

public class TopicServiceImpl implements TopicService {

	@Override
	public List<Topic> findAll(Integer pagenumber, Integer pagesize) {
		
		TopicDAO dao=(TopicDAO)ObjectFactory.getObject("topicdao");
		try {
			return dao.findAll(pagenumber,pagesize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer total() {
		
		TopicDAO dao=(TopicDAO)ObjectFactory.getObject("topicdao");
		
		try {
			return dao.total();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
