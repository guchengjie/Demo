package com.itany.bbs.action;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itany.bbs.entity.Board;
import com.itany.bbs.entity.Paginate;
import com.itany.bbs.entity.Topic;
import com.itany.bbs.entity.User;
import com.itany.bbs.service.BoardService;
import com.itany.bbs.service.TopicService;
import com.itany.factory.ObjectFactory;

public class TopicAction {

	// 获取帖子版块
	public String findAllTopic(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("findAllTopic commit");
		BoardService service = (BoardService) ObjectFactory
				.getObject("boardservice");
		TopicService service2 = (TopicService) ObjectFactory
				.getObject("topicservice");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("users");
		if (user == null) {
			request.setAttribute("error", "请登陆后查看");
			return "login";

		}
		// 查找版块boardId 对象的名称
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		Board board = service.getBoardById(boardId);
		
		if(board == null){
			//response.sendError(404);
			request.setAttribute("loginrr", "你要查找的信息不存在，请登陆后重新操作");
			return "fail";
		}
		
		request.setAttribute("board", board);

		System.out.println("1: " + board.getBoardName());

		// 页号如果为空默认为1
		int pageNo;
		String num = request.getParameter("pageNo");
		if (num != null && !num.trim().equals("")) {
			pageNo = Integer.parseInt(num);
		} else {
			pageNo = 1;
		}
		// int pageNo = num==null ? 1: Integer.parseInt(num);
		// 新建一个分页对象
		Paginate page = new Paginate();

		page.setPageNo(pageNo);
		page.setPageSize(5);

		// 获取主题帖子的数量
		int records = service2.getTopicCount(boardId);
		page.setRecords(records);

		// 计算最大的页码
		page.calc();
		request.setAttribute("page", page);
		System.out.println("getMaxPageNo:" + page.getMaxPageNo());
		// 获取主题对象的 list 集合
		List<Topic> topics = service2.findTopicByPage(boardId, page);
		request.setAttribute("topics", topics);

		return "success";

	}

	// 发表话题 页面
	public String publish(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		BoardService service2 = (BoardService) ObjectFactory
				.getObject("boardservice");
		TopicService service = (TopicService) ObjectFactory
				.getObject("topicservice");

		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("users");
		if (user == null) {
			return "login";
		}

		String title = request.getParameter("title");
		String content = request.getParameter("contents");
		// 禁止发 空帖子
		if (title == null || "".equals(title.trim()) || content == null
				|| "".equals(content.trim())) {
			request.setAttribute("kong", "请填写文字发送");
			return "fail";

		}

		int boardId = Integer.parseInt(request.getParameter("boardId"));

		Board board = service2.getBoardById(boardId);

		session.setAttribute("board", board);

		System.out.println("333: " + board.getBoardName());

		int userid = user.getUserid();
		// 创建时间
		java.util.Date d = new java.util.Date();
		Timestamp postdate = new Timestamp(d.getTime());
		// 最后修改时间
		Timestamp modifydate = postdate;

		// Topic topic = new Topic(null, title, content, "", null, null, null,
		// null, userid, boardId, postdate, modifydate, null);

		Topic tp = new Topic();
		tp.setTitle(title.trim());
		tp.setTcontents(content.trim());
		tp.setBoardid(boardId);
		tp.setUserid(user.getUserid());

		// 发帖成功返回新帖id，失败返回0
		int topic = service.addTopic(tp);
		if (topic > 0) {
			return "success";
		}
		return "fail";

	}

	public static void main(String[] args) {
		BoardService service = (BoardService) ObjectFactory
				.getObject("boardservice");

		System.out.println(service.getBoardById(7).getBoardName());

		TopicService service2 = (TopicService) ObjectFactory
				.getObject("topicservice");
		int records = service2.getTopicCount(5);
		System.out.println(records);
		Paginate page = new Paginate();
		page.setRecords(records);

		System.out.println(page.getPageSize());

	}
	
	//获取帖子加精的数据
	public String addtop(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		TopicService service = (TopicService) ObjectFactory
				.getObject("topicservice");
		
		
		List<Topic> list=service.findAll();
		
		request.setAttribute("top",list);
		
		return "success";

	}
	
	//获取帖子置顶的数据
		public String addgood(HttpServletRequest request,
				HttpServletResponse response) throws Exception {

			TopicService service = (TopicService) ObjectFactory
					.getObject("topicservice");
			
			List<Topic> list=service.findGood();
			
			request.setAttribute("good", list);
		
			
			return "success";

		}
	
}
