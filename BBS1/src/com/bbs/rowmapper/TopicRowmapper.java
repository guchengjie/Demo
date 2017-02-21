package com.bbs.rowmapper;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import com.bbs.entity.Topic;
import com.bbs.entity.Userinfo;
import com.bbs.util.DateHelper;
import com.itany.jdbc.util.RowMapper;


public class TopicRowmapper implements RowMapper {
	
	private RowMapper map=new UserinfoRowMapper();
	@Override
	public Object mapRow(ResultSet rs) throws Exception {
		Topic one = new Topic();
        one.setTopicid(rs.getInt("topicId"));
        one.setTitle(rs.getString("title"));
        one.setTcontents(rs.getString("tcontents"));
        one.setTreplycontents(rs.getString("treplycontents"));
        one.setTface(rs.getInt("tface"));
        one.setIsreply(rs.getInt("isreply"));
        one.setReadpoint(rs.getInt("readpoint"));
        one.setAccesspoint(rs.getInt("accesspoint"));
        one.setUserid(rs.getInt("userid"));
        one.setBoardid(rs.getInt("boardid"));
       
        one.setPostdate(DateHelper.fromDateToString(rs.getTimestamp("postdate")));
        
        one.setModifydate(DateHelper.fromDateToString(rs.getTimestamp("modifydate")));
        
		one.setState(rs.getInt("state"));
		one.setIsgood(rs.getInt("isgood"));
		one.setIstop(rs.getInt("istop"));
		
		try{
			Userinfo uinfo=(Userinfo)map.mapRow(rs);
			one.setUinfo(uinfo);
		}catch(Exception ex){
			System.out.println("未能找到和user有关的信息");
		}
		return one;
	}

}
