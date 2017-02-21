package com.bbs.entity;

import java.io.Serializable;

/**
 * 用于存放话题信息的实体对象
 */
public class Topic implements Serializable
{
    private Integer topicid;
    private String title;
    private String tcontents;
    private String treplycontents;
    private Integer tface;
    private Integer isreply;
    private Integer istop;
    private Integer isgood;
	private Integer readpoint;
    private Integer accesspoint;
    private Integer userid;
    private Integer boardid;
    private String postdate;
    private String modifydate;
    private Integer state;
    private Userinfo uinfo;
    
    
    public Userinfo getUinfo() {
		return uinfo;
	}


	public void setUinfo(Userinfo uinfo) {
		this.uinfo = uinfo;
	}


	public Topic(Integer topicid, String title, String tcontents,
			String treplycontents, Integer tface, Integer isreply,
			Integer istop, Integer isgood, Integer readpoint,
			Integer accesspoint, Integer userid, Integer boardid,
			String postdate, String modifydate, Integer state) {
		this.topicid = topicid;
		this.title = title;
		this.tcontents = tcontents;
		this.treplycontents = treplycontents;
		this.tface = tface;
		this.isreply = isreply;
		this.istop = istop;
		this.isgood = isgood;
		this.readpoint = readpoint;
		this.accesspoint = accesspoint;
		this.userid = userid;
		this.boardid = boardid;
		this.postdate = postdate;
		this.modifydate = modifydate;
		this.state = state;
	}


	public Integer getTopicid() {
		return topicid;
	}


	public void setTopicid(Integer topicid) {
		this.topicid = topicid;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getTcontents() {
		return tcontents;
	}


	public void setTcontents(String tcontents) {
		this.tcontents = tcontents;
	}


	public String getTreplycontents() {
		return treplycontents;
	}


	public void setTreplycontents(String treplycontents) {
		this.treplycontents = treplycontents;
	}


	public Integer getTface() {
		return tface;
	}


	public void setTface(Integer tface) {
		this.tface = tface;
	}


	public Integer getIsreply() {
		return isreply;
	}


	public void setIsreply(Integer isreply) {
		this.isreply = isreply;
	}


	public Integer getIstop() {
		return istop;
	}


	public void setIstop(Integer istop) {
		this.istop = istop;
	}


	public Integer getIsgood() {
		return isgood;
	}


	public void setIsgood(Integer isgood) {
		this.isgood = isgood;
	}


	public Integer getReadpoint() {
		return readpoint;
	}


	public void setReadpoint(Integer readpoint) {
		this.readpoint = readpoint;
	}


	public Integer getAccesspoint() {
		return accesspoint;
	}


	public void setAccesspoint(Integer accesspoint) {
		this.accesspoint = accesspoint;
	}


	public Integer getUserid() {
		return userid;
	}


	public void setUserid(Integer userid) {
		this.userid = userid;
	}


	public Integer getBoardid() {
		return boardid;
	}


	public void setBoardid(Integer boardid) {
		this.boardid = boardid;
	}


	public String getPostdate() {
		return postdate;
	}


	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}


	public String getModifydate() {
		return modifydate;
	}


	public void setModifydate(String modifydate) {
		this.modifydate = modifydate;
	}


	public Integer getState() {
		return state;
	}


	public void setState(Integer state) {
		this.state = state;
	}


	public Topic()
    {
    
    }
    
}
