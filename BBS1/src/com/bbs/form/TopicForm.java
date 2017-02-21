package com.bbs.form;

import org.apache.catalina.User;
import org.apache.struts.action.ActionForm;

import com.bbs.entity.Topic;
import com.bbs.entity.Userinfo;

public class TopicForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int pagenumber=1;
	private int pagesize=6;
	
	Topic ti=new Topic();
	
	public Topic getTi() {
		return ti;
	}
	public void setTi(Topic ti) {
		this.ti = ti;
	}
	public int getPagenumber() {
		return pagenumber;
	}
	public void setPagenumber(int pagenumber) {
		this.pagenumber = pagenumber;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

}
