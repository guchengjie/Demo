package com.itany.bbs.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itany.bbs.dao.UserDao;
import com.itany.bbs.entity.User;
import com.itany.bbs.rowmapper.UserRowmapper;
import com.itany.jdbc.util.JDBCTemplate;
import com.itany.jdbc.util.JDBCUtil;
import com.itany.jdbc.util.KeyHolder;
import com.itany.jdbc.util.PreparedStatementCreator;

public class UserDaoImpl implements UserDao {
	
	private JDBCTemplate templete = new JDBCTemplate();
	private QueryRunner query = new QueryRunner();
	private UserRowmapper rowmapper = new UserRowmapper();
	private Connection conn=JDBCUtil.getConnection();
	
	@Override
	// 登录时候 验证用户是否存在
	public User isValidUser(String name, String pass) {
		String sql = "select *  from users where loginname=? and loginpwd = ?";
		Object[] params = new Object[2];
		params[0]= name;
		params[1] =  pass;
		@SuppressWarnings("unchecked")
		List<User> list = this.templete.query(sql, rowmapper, new Object[]{name,pass});
		//如果list.size() 为0  没有改用户返回为null,否则 否则返回得到的对象
		return list.size() == 0 ? null : list.get(0);
		
//		String sql="select * from users where loginname=? and loginpwd=?";
//        try
//        {
//            conn=JDBCUtil.getConnection();
//            ResultSetHandler<User> rsh=
//                new BeanHandler<User>(User.class);
//            User user=query.query(conn,sql, rsh, name,pass);
//            return user;
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//       
//        return null;
		
	}
	
	//添加用户用于注册  
	@Override
	public int addUser(User user) {
		final String sql = "insert into users(loginname,loginpwd,email,head,regtime) values(?,?,?,?,?)";
		KeyHolder kh = new KeyHolder();
		final Object[] params = {user.getLoginname(),user.getLoginpwd(),user.getEmail(),user.getHead(),user.getRegtime()};
		this.templete.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws Exception {
				PreparedStatement pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				
				pst.setObject(1, params[0]);
				pst.setObject(2, params[1]);
				pst.setObject(3, params[2]);
				pst.setObject(4, params[3]);
				pst.setObject(5, params[4]);
				
//				for(int i=0;i<params.length;i++){
//					pst.setObject(i+1, params[i]);
//				}
				
				
				return pst;
			}
		}, kh);
		//返回 Integer 类型 转换为 int 型
		return ((Long)kh.getKey()).intValue();
	}

	// 验证用户名是否存在：如存在返回该用户id 大于0 则存在 小于0 不存在
	@Override
	public int findIdByUserName(String name) {
		String sql = "SELECT * FROM USERS where loginname = ?";
		Object[] params = new Object[1];
		params[0] = name;
		@SuppressWarnings("unchecked")
		List<User> list = this.templete.query(sql, rowmapper, params);
		//得到用户的id
		if(list.size() == 0){
			return 0;
		}else{
			return list.get(0).getUserid();
		}
		
	}

	@Override
	public User findUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByEmail(String name, String email) {
		
		return null;
	}

	@Override
	public boolean addUserPoint(int userId, int addPoint) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delUser(int userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyUserState(int userId, int state) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> findUsersOrder(String order, boolean isASC,
			boolean isPaginate, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUsersByName(String name, int start, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifyLoginPwd(User user) {
		String sql = "UPDATE USERS SET loginpwd = ? WHERE userid = ?";
		this.templete.update(sql, new Object[] {user.getLoginpwd(),user.getUserid()});
		return true;
	}

	@Override
	public int findIdByEmail(String email) {
		String sql = "select * from USERS where email =?";
		 ResultSetHandler<Integer> rsh= new ScalarHandler<Integer>();
		try {
			Integer ret = query.query(conn,sql,rsh,email);
			return ret == null ? 0 : ret.intValue();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
		// 一条数据 select *  所以用 Integer
//		String sql = "SELECT * FROM USERS WHERE email = ?";
//		List<User> list = this.templete.query(sql, rowmapper, new Object[] {email});
//		return list.size() == 0 ? 0 : list.get(0).getUserid();
		
	}

}
