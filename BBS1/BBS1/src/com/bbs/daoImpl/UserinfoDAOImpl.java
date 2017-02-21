package com.bbs.daoImpl;

import java.sql.SQLException;
import java.util.List;

import com.bbs.dao.UserinfoDAO;
import com.bbs.entity.Userinfo;
import com.bbs.rowmapper.UserinfoRowMapper;
import com.itany.jdbc.util.JDBCTemplate;
import com.itany.jdbc.util.RowMapper;

public class UserinfoDAOImpl implements UserinfoDAO {
	
	JDBCTemplate template=new JDBCTemplate();
	@Override
	public Userinfo findByUserid() throws SQLException {
		
		String sql="select * from USERS ";
		
		RowMapper rm= new UserinfoRowMapper();
		
		List<Userinfo> list =this.template.query(sql, rm,null);
		
		return list.get(0);
	}
	public static void main(String[] args) {
		UserinfoDAOImpl as=new UserinfoDAOImpl();
		try {
			System.out.println(as.findByUserid().getLoginname());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
