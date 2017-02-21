package com.itany.bbs.rowmapper;

import java.sql.ResultSet;

import com.itany.bbs.entity.Topic;
import com.itany.jdbc.util.RowMapper;

public class TopicRowmapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs) throws Exception {
		Topic one = new Topic();
        one.setTopicId(rs.getInt("topicId"));
        one.setTitle(rs.getString("title"));
        one.setTcontents(rs.getString("tcontents"));
        one.setTreplycontents(rs.getString("treplycontents"));
        one.setTface(rs.getInt("tface"));
        one.setIsreply(rs.getInt("isreply"));
        one.setReadpoint(rs.getInt("readpoint"));
        one.setAccesspoint(rs.getInt("accesspoint"));
        one.setUserid(rs.getInt("userid"));
        one.setBoardid(rs.getInt("boardid"));
        one.setPostdate(rs.getTimestamp("postdate"));
        one.setModifydate(rs.getTimestamp("modifydate"));
		one.setState(rs.getInt("state"));
		
		return one;
	}

}
