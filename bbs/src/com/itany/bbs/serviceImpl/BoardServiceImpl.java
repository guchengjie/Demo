package com.itany.bbs.serviceImpl;

import java.util.List;
import java.util.Map;

import com.itany.bbs.dao.BoardDao;
import com.itany.bbs.entity.Board;
import com.itany.bbs.service.BoardService;
import com.itany.factory.ObjectFactory;

public class BoardServiceImpl implements BoardService {
	BoardDao dao = (BoardDao) ObjectFactory.getObject("boarddao");

	@Override
	/**
	 * 查找所有版块：Map中以父版块id为key，子版块列表为value；一级版块的key固定为0
	 */
	public Map<Integer, List<Board>> findAllBoard() {
		return this.dao.findAllBoard();
	}

	/**
	 * 用于存放版块信息的实体对象
	 */
	@Override
	public Board getBoardById(int id) {

		return this.dao.getBoardById(id);
	}

	/**
	 * 可选：添加版块
	 */
	@Override
	public int addBoard(Board board) {
		return this.dao.addBoard(board);
	}

	@Override
	public List<Board> getBoards(int pid) {
		return this.dao.getBoards(pid);
	}

	@Override
	public boolean exists(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyState(int id, int newState, int oldState) {
		// TODO Auto-generated method stub
		return false;
	}

}
