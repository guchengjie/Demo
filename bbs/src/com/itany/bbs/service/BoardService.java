package com.itany.bbs.service;

import java.util.List;
import java.util.Map;

import com.itany.bbs.entity.Board;

/**
 * 
 *  论坛版块相关数据访问接口
 */
public interface BoardService
{
    
    /**
     * 查找所有版块：Map中以父版块id为key，子版块列表为value；一级版块的key固定为0
     * @return 所有版块的映射集合
     */
    public Map<Integer, List<Board>> findAllBoard();
    /**
     * 根据版块id查找版块信息
     * @param id    版块id
     * @return      版块对象
     */
    public Board getBoardById(int id);
    /**
     * 可选：添加版块
     */
    public int addBoard(Board board);
    /**
     * 可选：根据父版块id查找子版块
     */
    public List<Board> getBoards(int pid);
    /**
     * 可选：查找指定版块名是否存在
     */
    public boolean exists(String name);
    /**
     * 可选：修改版块状态
     */
    public boolean modifyState(int id, int newState, int oldState); 
}
