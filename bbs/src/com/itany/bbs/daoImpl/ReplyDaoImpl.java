package com.itany.bbs.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itany.bbs.dao.ReplyDao;
import com.itany.bbs.entity.Paginate;
import com.itany.bbs.entity.Reply;
import com.itany.bbs.rowmapper.ReplyRowmapper;
import com.itany.jdbc.util.JDBCTemplate;
import com.itany.jdbc.util.JDBCUtil;
import com.itany.jdbc.util.KeyHolder;
import com.itany.jdbc.util.PreparedStatementCreator;

public class ReplyDaoImpl implements ReplyDao {

	private JDBCTemplate templete = new JDBCTemplate();
	private ReplyRowmapper rowmapper = new ReplyRowmapper();
	private QueryRunner qr = new QueryRunner();
	private Connection conn = JDBCUtil.getConnection();

	/**
	 * 根据主题帖id获取回复数量
	 * 
	 * @param topicId
	 * @return
	 */

	public int getReplyCount(int topicId) {
		String sql = "select count(*) from replys where state>0 and topicid="
				+ topicId;
		ResultSetHandler<Long> rsh = new ScalarHandler<Long>();
		try {
			Long ret = qr.query(conn, sql, rsh);
			return ret == null ? 0 : ret.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 根据主题帖id分页查询回帖列表
	 * 
	 * @param topicId
	 *            主题帖id
	 * @param page
	 *            分页对象
	 * @return
	 */
	public List<Reply> findReplyByPage(int topicId, Paginate page) {
		String sql = "SELECT * FROM REPLYS WHERE topicid = ? and state=1 order by replyId desc LIMIT ?,?";
		Integer start = (page.getPageNo() - 1) * page.getPageSize();

		// Object[] params = new Object[3];
		// params[0] = topicId;
		// params[1] = start;
		// params[2] = page.getPageSize();
		// List<Reply> list = this.templete.query(sql, rowmapper, params);
		//
		ResultSetHandler<List<Reply>> rsh = new BeanListHandler<Reply>(
				Reply.class);

		List<Reply> list;
		try {
			list = qr.query(conn, sql, rsh, topicId, start, page.getPageSize());
			return list;
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 修改回复帖
	 * 
	 * @param t
	 *            回复帖对象
	 * @return true-修改成功；false-失败
	 */
	public boolean modifyReply(Reply r) throws Exception {

		String sql = "UPDATE REPLYS SET rtitle = ?,rcontents = ?,modifydate = now() WHERE replyId = ?";
		Object[] params = new Object[3];
		params[0] = r.getRtitle();
		params[1] = r.getRcontents();
		params[2] = r.getReplyId();

		this.templete.update(sql, params);
		return true;
	}

	/**
	 * 删除回复帖
	 * 
	 * @param replyId
	 *            回复帖id
	 * @param userId
	 *            用户id
	 * @return true-删除成功；false-失败
	 */
	public boolean deleteReply(int replyId, int userId) throws Exception {
		String sql = "UPDATE REPLYS SET state = 0 WHERE replyId = ? and userid = ?";
		// Object[] params = new Object[2];
		// params[0] = replyId;
		// params[1] = userId;
		// this.templete.update(sql, params);

		return qr.update(conn, sql, replyId, userId) == 0 ? false : true;

	}

	/**
	 * 添加回复帖，用于用户回帖
	 * 
	 * @param t
	 *            回复帖对象
	 * @return 回帖成功返回新回帖id，失败返回0
	 */
	public int addReply(Reply r) {
		KeyHolder keyHolder = new KeyHolder();
		final String sql = "INSERT INTO REPLYS(rtitle,rcontents,userid,topicid,postdate,modifydate) value(?,?,?,?,now(),now())";
		final Object param[] = { r.getRtitle(), r.getRcontents(),
				r.getUserid(), r.getTopicid() };
		this.templete.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws Exception {
				PreparedStatement ps = conn.prepareStatement(sql,
						PreparedStatement.RETURN_GENERATED_KEYS);
				for (int i = 0; i < param.length; i++) {
					ps.setObject(i + 1, param[i]);
				}
				return ps;
			}
		}, keyHolder);
		return ((Long) keyHolder.getKey()).intValue();
	}

	/**
	 * 根据回复帖id获取回复帖信息
	 * 
	 * @param 回复帖replyId
	 * @return 回复帖对象
	 */
	public Reply findReplyById(int replyId) {
		String sql = "SELECT * FROM REPLYS WHERE replyId = ? and state =1";
		List<Reply> list = this.templete.query(sql, rowmapper,
				new Object[] { replyId });
		return list.size() == 0 ? null : list.get(0);
	}

}
