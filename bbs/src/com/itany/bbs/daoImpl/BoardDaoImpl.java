package com.itany.bbs.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;

import com.itany.bbs.dao.BoardDao;
import com.itany.bbs.entity.Board;
import com.itany.bbs.rowmapper.BoardRowmapper;
import com.itany.jdbc.util.JDBCTemplate;

public class BoardDaoImpl implements BoardDao {
	private JDBCTemplate templete = new JDBCTemplate();
	private static QueryRunner query = new QueryRunner();
	
	@Override
	/**
	 * 查找所有版块：Map中以父版块id为key，子版块列表为value；一级版块的key固定为0
	 * @return 所有版块的映射集合
	 */
	public Map<Integer, List<Board>> findAllBoard() {
		Map<Integer, List<Board>> boardMap = new HashMap<Integer, List<Board>>();
		//查询所有父版块
		String sql="select * from boards where parentId = ?";
		Object[] params = new Object[1];
		params[0] = 0;
		List<Board> parents=this.templete.query(sql, new BoardRowmapper(), params);
		
		//将父版块放入map
		boardMap.put(0, parents);
		//遍历父版块，查询每个父版块下的子版块
		for(Board one:parents){
		    int key=one.getBoardId();
		    //依次查找指定父版块中的子版块
		    String sql1="select * from boards where parentId = ?";
		    Object[] param = new Object[1];
		    param[0] = key;
		    List<Board> boards=this.templete.query(sql1, new BoardRowmapper(), param);
		    //将父版块的id和其子版块列表存入map
		    boardMap.put(key, boards);
		}
		
		return boardMap;
	}

	@Override
	/**
	 * 根据版块id查找版块信息
	 * @param id    版块id
	 * @return      版块对象
	 */
	public Board getBoardById(int id) {
		
		String sql = "select * from boards where boardId = ?";
		Object[] params = new Object[1];
		params[0] = id;
		List<Board> list = this.templete.query(sql, new BoardRowmapper(), params);
		
		return list.size()==0 ? null :list.get(0);
	}

	/**
	 * 可选：添加版块
	 */
	@Override
	public int addBoard(Board board) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 可选：根据父版块id查找子版块
	 */
	@Override
	public List<Board> getBoards(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 可选：查找指定版块名是否存在
	 */
	@Override
	public boolean exists(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 可选：修改版块状态
	 */
	@Override
	public boolean modifyState(int id, int newState, int oldState) {
		// TODO Auto-generated method stub
		return false;
	}

}
