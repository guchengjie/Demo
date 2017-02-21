package com.itany.bbs.action;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itany.bbs.entity.Board;
import com.itany.bbs.service.BoardService;
import com.itany.factory.ObjectFactory;
/**
 * 获取首页版块信息
 * @author appleuser
 *
 */
public class BoardAction {
	BoardService service = (BoardService) ObjectFactory.getObject("boardservice");
	
	public String findAllBoard(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		//获取所有父板块 子板块集合
        HashMap<Integer, List<Board>> boardMap = (HashMap<Integer, List<Board>>) this.service.findAllBoard();
        //设置版块集合属性
        session.setAttribute("boards", boardMap);
        System.out.println(boardMap.size());
        return "success";
		
	}
	
}
