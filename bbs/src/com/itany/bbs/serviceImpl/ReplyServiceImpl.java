package com.itany.bbs.serviceImpl;

import java.util.List;

import com.itany.bbs.dao.ReplyDao;
import com.itany.bbs.entity.Paginate;
import com.itany.bbs.entity.Reply;
import com.itany.bbs.exception.RelyServiceException;
import com.itany.bbs.service.ReplyService;
import com.itany.factory.ObjectFactory;

public class ReplyServiceImpl implements ReplyService {
	ReplyDao dao = (ReplyDao) ObjectFactory.getObject("replaycdao");
	@Override
	public int getReplyCount(int topicId) {
		return this.dao.getReplyCount(topicId);
	}

	@Override
	public List<Reply> findReplyByPage(int topicId, Paginate page) {
		return this.dao.findReplyByPage(topicId, page);
	}

	@Override
	public boolean modifyReply(Reply r) throws Exception {
		return this.dao.modifyReply(r);
	}

	@Override
	public boolean deleteReply(int replyId, int userId) throws Exception  {
		
		return this.dao.deleteReply(replyId, userId);
	}

	@Override
	public int addReply(Reply r) {
		return this.dao.addReply(r);
	}

	@Override
	public Reply findReplyById(int replyId) throws RelyServiceException {
		Reply reply = null;
		try {
			reply= this.dao.findReplyById(replyId);
			return reply;
		} catch (Exception e) {
			throw new RelyServiceException("请重新登录！");
			
		}
	}

}
