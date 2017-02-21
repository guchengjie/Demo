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
	public List<Topic> findAll(Integer pagenumber,Integer pagesize) throws SQLException {
		
		String sql="select * from TOPICS a,USERS b where a.userid=b.userid and a.state=1 limit ?,?";
		
		RowMapper rm=new TopicRowmapper();
		Integer start=(pagenumber-1)*pagesize;
		
		return this.template.query(sql, rm,new Object[]{start,pagesize});	
	}
	
	
	@Override
	public Integer total() throws SQLException {
		
		String sql="select count(*) from TOPICS";
		
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


	@Override
	public Integer addtop(Integer id,Integer zx) throws SQLException {
		
		String sql="update TOPICS set istop=? where topicid=?";
		
		this.template.update(sql,new Object[]{zx,id});
		
		return 1;
	}


	@Override
	public Integer addgood(Integer id, Integer zx) throws SQLException {
		
		String sql="update TOPICS set isgood=? where topicid=?";
		
		this.template.update(sql,new Object[]{zx,id});
		
		return 1;
	}
	
	@Override
	public Topic addmodify(Integer id) throws SQLException {
		
		String sql="select * from TOPICS a,USERS b where a.userid=b.userid and topicid=?";
		
		RowMapper rm=new TopicRowmapper();
		
		List<Topic> list=this.template.query(sql, rm,new Object[]{id});
		
		return list.get(0);
		
	}
	
	@Override
	public Integer adddelet(Integer id) throws SQLException {
		
		String sql="update TOPICS set state=? where topicid=? ";
		
		this.template.update(sql, new Object[]{0,id});
		
		return 1;
		
	}


	@Override
	public Integer addchange(Topic ti) throws SQLException {
		
		String sql="update TOPICS set title=?,tcontents=?,modifydate=? where topicid=?";
		
		this.template.update(sql,new Object[]{ti.getTitle(),ti.getTcontents(),ti.getModifydate(),ti.getTopicid()});
		
		return 1;
	}

}
