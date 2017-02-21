package com.itany.bbs.rowmapper;

import java.sql.ResultSet;

import com.itany.bbs.entity.Reply;
import com.itany.jdbc.util.RowMapper;

public class ReplyRowmapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs) throws Exception {
		
		Reply one = new Reply();
		one.setReplyId(rs.getInt("replyId"));
		one.setRtitle(rs.getString("rtitle"));
		one.setRcontents(rs.getString("rcontents"));
		one.setRface(rs.getInt("rface"));
		one.setUserid(rs.getInt("userid"));
		one.setTopicid(rs.getInt("topicid"));
		one.setPostdate(rs.getTimestamp("postdate"));
		one.setModifydate(rs.getTimestamp("modifydate"));
		one.setState(rs.getInt("state"));
		return one;
	}

}
