package com.bbs.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bbs.dao.TopicDAO;
import com.bbs.entity.Topic;
import com.bbs.rowmapper.TopicRowmapper;
import com.itany.jdbc.util.JDBCTemplate;
import com.itany.jdbc.util.ResultSetExtractor;
import com.itany.jdbc.util.RowMapper;

public class TopicDAOImpl implements TopicDAO {
	
	JDBCTemplate template=new JDBCTemplate();
	@Override
	public List<Topic> findAll(Integer pagenumber, Integer pagesize) throws SQLException {
		
		String sql="select * form USERS where limit ?,?";
		
		Integer start=(pagenumber-1)*pagesize;
		
		RowMapper rm=new TopicRowmapper();
		
		return this.template.query(sql, rm,new Object[]{start,pagesize});	
	}
	
	
	@Override
	public Integer total() throws SQLException {
		
		String sql="select count(*) from topic";
		
		ResultSetExtractor rse= new ResultSetExtractor() {
			
			@Override
			public Object extractData(ResultSet rs) throws Exception {
				rs.next();
				int total=rs.getInt(1);
				return total;
			}
		};
		
		return (Integer)this.template.query(sql,rse,null);
		
	}

}
