package com.itany.bbs.serviceImpl;

import java.util.List;

import com.itany.bbs.dao.TopicDao;
import com.itany.bbs.entity.Paginate;
import com.itany.bbs.entity.Topic;
import com.itany.bbs.service.TopicService;
import com.itany.factory.ObjectFactory;

public class TopicServiceImpl implements TopicService {
	TopicDao dao = (TopicDao) ObjectFactory.getObject("topicdao");
	@Override
	public Topic findLastTopicByBoard(int boardId) {
		
		return this.dao.findLastTopicByBoard(boardId);
	}

	@Override
	public List<Topic> findTopicByPage(int boardId, Paginate page) {
		return this.dao.findTopicByPage(boardId, page);
	}

	@Override
	public int getTopicCount(int boardId) {
		
		return this.dao.getTopicCount(boardId);
	}

	@Override
	public Topic findTopicById(int topicId) {
		return this.dao.findTopicById(topicId);
	}

	@Override
	public int addTopic(Topic t) {
		return this.dao.addTopic(t);
	}

	@Override
	public boolean modifyTopic(Topic t) throws Exception {
		return this.dao.modifyTopic(t);
	}

	@Override
	public boolean deleteTopic(int topicId, int userId){
		try {
			return this.dao.deleteTopic(topicId, userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Topic> findAll()  {
			try {
				return this.dao.findAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}

	@Override
	public List<Topic> findGood()  {
			try {
				return this.dao.findAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}
}
