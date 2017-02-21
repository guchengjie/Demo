package com.itany.bbs.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itany.bbs.entity.Board;
import com.itany.bbs.entity.Paginate;
import com.itany.bbs.entity.Reply;
import com.itany.bbs.entity.Topic;
import com.itany.bbs.entity.User;
import com.itany.bbs.service.BoardService;
import com.itany.bbs.service.ReplyService;
import com.itany.bbs.service.TopicService;
import com.itany.factory.ObjectFactory;

public class ReplyAction {

	BoardService boardservice = (BoardService) ObjectFactory
			.getObject("boardservice");
	ReplyService replyservice = (ReplyService) ObjectFactory
			.getObject("replayservice");
	TopicService topicservice = (TopicService) ObjectFactory
			.getObject("topicservice");

	// 所有帖子页面
	public String findAllReplay(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		System.out.println(request.getParameter("topicId")+"-----");
		
		
		String id = request.getParameter("topicId");
		
		if(id == null){
			//response.sendError(404);
			request.setAttribute("loginrr", "你要查找的信息不存在，请登陆后在操作");
			return "fail";
		}
		
		int topicId = Integer.parseInt(id);

		Topic topic = this.topicservice.findTopicById(topicId);

		int boardid = topic.getBoardid();

		Board board = this.boardservice.getBoardById(boardid);

		System.out.println(board.getBoardId());

		// 页号如果为空默认为1
		int pageNo;
		String num = request.getParameter("pageNo");
		if (num != null && !num.trim().equals("")) {
			pageNo = Integer.parseInt(num);
		} else {
			pageNo = 1;
		}
		// new 一个分页对象
		Paginate page = new Paginate();

		page.setPageNo(pageNo);
		page.setPageSize(5);
		page.setRecords(this.replyservice.getReplyCount(topicId));
		page.calc();

		List<Reply> replys = this.replyservice.findReplyByPage(topicId, page);
		
		session.setAttribute("secboard", board);
		request.setAttribute("replys", replys);
		request.setAttribute("topic", topic);
		request.setAttribute("page", page);
		return "success";

	}

	// 发布回复帖子
	public String post(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("users");
		if (user == null) {
			return "err";
		}
		int topicid = Integer.parseInt(request.getParameter("topicId"));
		String title = request.getParameter("rtitle");
		String content = request.getParameter("rcontents");
		if (title == null || "".equals(title.trim()) || content == null
				|| "".equals(content.trim())) {
			return "fail";
		}

		Reply replay = new Reply();
		replay.setRtitle(title.trim());
		replay.setRcontents(content.trim());
		replay.setTopicid(topicid);
		replay.setUserid(user.getUserid());

		int ret = this.replyservice.addReply(replay);

		if (ret > 0) {
			return "success";
		}
		return "fail";

	}

	// 删除帖子页面
	public String delete(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("删除发布帖子页面");
		int replyId = Integer.parseInt(request.getParameter("replyId"));
		int userId = Integer.parseInt(request.getParameter("userid"));
		
		System.out.println(replyId+"=====");
		System.out.println(userId+"=====");
		
		Reply reply = this.replyservice.findReplyById(replyId);
		if(reply == null){
			//response.sendError(404);
			request.setAttribute("loginrr", "你要查找的信息不存在，请登陆后在操作");
			return "fail";
		}
		
		int topicId = reply.getTopicid();
		this.replyservice.deleteReply(replyId, userId);
		
		request.setAttribute("topicId", topicId);
		return "success";

	}
	 
	// 所有帖子页面
		public String remodify(HttpServletRequest request,
				HttpServletResponse response) throws Exception {

			HttpSession session = request.getSession();
			System.out.println("remodify: " + request.getParameter("topicId")+"-----");
			
			String id = request.getParameter("topicId");
			int topicId = Integer.parseInt(id);
			int replyId = Integer.parseInt(request.getParameter("replyId"));
			
			Topic topic = this.topicservice.findTopicById(topicId);

			int boardid = topic.getBoardid();

			Board board = this.boardservice.getBoardById(boardid);

			System.out.println(board.getBoardId());

			// 页号如果为空默认为1
			int pageNo;
			String num = request.getParameter("pageNo");
			if (num != null && !num.trim().equals("")) {
				pageNo = Integer.parseInt(num);
			} else {
				pageNo = 1;
			}
			// new 一个分页对象
			Paginate page = new Paginate();

			page.setPageNo(pageNo);
			page.setPageSize(5);
			page.setRecords(this.replyservice.getReplyCount(topicId));
			page.calc();

			List<Reply> replys = this.replyservice.findReplyByPage(topicId, page);
			Reply reply = this.replyservice.findReplyById(replyId);
			
			request.setAttribute("replys", reply);
			request.setAttribute("secboard", board);
			request.setAttribute("repalys", replys);
			request.setAttribute("topic", topic);
			request.setAttribute("page", page);
			return "success";

		}
	
	// 修改发布帖子页面
	public String modify(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("修改发布帖子页面");
		
		int replyId = Integer.parseInt(request.getParameter("replyId"));
		System.out.println(replyId+"==========");
		
		String rtitle = request.getParameter("title");
		String rcontents = request.getParameter("contents");
		
		System.out.println(rtitle+"==========");
		System.out.println(rcontents+"==========");
		
//		Reply reply = this.replyservice.findReplyById(replyId);
//		request.setAttribute("replys", reply);
 
		Reply r = new Reply();
		r.setRtitle(rtitle.trim());
		r.setRcontents(rcontents.trim());
		r.setReplyId(replyId);
		// 修改帖子
		
		this.replyservice.modifyReply(r);

		return "success";

	}

}
