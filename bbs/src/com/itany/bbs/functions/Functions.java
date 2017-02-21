package com.itany.bbs.functions;

import java.sql.Connection;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itany.bbs.entity.Topic;
import com.itany.bbs.entity.User;
import com.itany.jdbc.util.JDBCUtil;

/**
 * 自定义函数标签 一个普通类，无需继承自任何父类或实现接口 在类中定义若干公有静态方法，一定要求返回值
 */
public class Functions {
	private static QueryRunner qr = new QueryRunner();
	static Connection con = JDBCUtil.getConnection();

	/**
	 * 根据版块id获取该版块的帖子数
	 * 
	 * @param boardId
	 * @return
	 */
	public static int getTopicCount(Integer boardId) {

		String sql = "select count(*) from topics where boardid=?";
		try {

			ResultSetHandler<Long> rsh = new ScalarHandler<Long>();
			Long ret = qr.query(con, sql, rsh, boardId);
			if (ret != null) {
				return ret.intValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;

	}

	/**
	 * 根据版块id查找最新发布的主题帖：如果没有则返回null
	 * 
	 * @param boardId
	 * @return
	 */
	public static Topic findLastTopicByBoard(Integer boardId) {

		String sql = "select * from topics where boardid=? order by postdate desc";
		try {
			ResultSetHandler<Topic> rsh = new BeanHandler<Topic>(Topic.class);
			return qr.query(con, sql, rsh, boardId);

		} catch (Exception e) {
		}
		return null;

	}

	/**
	 * 根据用户id查找用户对象：如找不到返回null
	 * 
	 * @param userId
	 * @return
	 */
	public static User findUser(Integer userId) {
		String sql = "select * from users where userid=? and state=1";
		try {

			ResultSetHandler<User> rsh = new BeanHandler<User>(User.class);
			User user = qr.query(con, sql, rsh, userId);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 根据回复帖id获取回复帖信息
	 * 
	 * @param topicId
	 * @return
	 */
	public static int getReplyCount(Integer topicId) {

		String sql = "select count(*) from replys where  topicid=? and state = 1";
		try {

			ResultSetHandler<Long> rsh = new ScalarHandler<Long>();
			Long ret = qr.query(con, sql, rsh, topicId);
			System.out.println(ret);
			if (ret != null) {
				return ret.intValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * 根据用户id获取 用户名信息
	 * 
	 * @param userId
	 * @return
	 */

	public static User findUserNameById(int userId) {
		String sql = "SELECT * FROM USERS  WHERE userid=?";
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			ResultSetHandler<User> rsh = new BeanHandler<User>(User.class);
			User user = qr.query(conn, sql, rsh, userId);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * 根据主题帖id获取回复数量
	 * 
	 * @param topicId
	 * @return写在function中
	 */
	public static int getReplyCount(int topicId) {
		String sql = "select count(*) from REPLYS WHERE topicid=?";
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			ResultSetHandler<Long> rsh = new ScalarHandler<Long>();
			Long ret = qr.query(conn, sql, rsh, topicId);
			if (ret != null) {
				return ret.intValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
