package com.bbs.serviceImpl;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.bbs.dao.TopicDAO;
import com.bbs.entity.Topic;
import com.bbs.service.TopicService;
import com.bbs.util.DateHelper;
import com.itany.factory.ObjectFactory;

public class TopicServiceImpl implements TopicService {

	@Override
	public List<Topic> findAll(Integer pagenumber,Integer pagesize) {
		
		TopicDAO dao=(TopicDAO)ObjectFactory.getObject("topicdao");
		try {
			return dao.findAll(pagenumber,pagesize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer total() {
		
		TopicDAO dao=(TopicDAO)ObjectFactory.getObject("topicdao");
		
		try {
			return dao.total();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer addtop(Integer id, Integer zx) {
		
		TopicDAO dao=(TopicDAO)ObjectFactory.getObject("topicdao");
		
		try {
			return dao.addtop(id, zx);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Integer addgood(Integer id, Integer zx) {
		
		TopicDAO dao=(TopicDAO)ObjectFactory.getObject("topicdao");
		
		try {
			return dao.addgood(id, zx);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;	
	}
	
	@Override
	public Topic addmodify(Integer id) {
		
		TopicDAO dao=(TopicDAO)ObjectFactory.getObject("topicdao");
		
		try {
			return dao.addmodify(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer adddelet(Integer id) {
		
		TopicDAO dao=(TopicDAO)ObjectFactory.getObject("topicdao");
		
		try {
			return dao.adddelet(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	

	@Override
	public Integer addchange(Topic ti) {
		
		TopicDAO dao=(TopicDAO)ObjectFactory.getObject("topicdao");
		try {
//			String time= DateHelper.fromDateToString(new Date());秒数数值不匹配
			
			Calendar  c=Calendar.getInstance();//对时间的每个区间做操作
			
			Integer year = c.get(Calendar.YEAR);
			Integer month = c.get(Calendar.MONTH);
			Integer date = c.get(Calendar.DATE);
			Integer hour = c.get(Calendar.HOUR_OF_DAY);
			Integer minute = c.get(Calendar.MINUTE);
			Integer second=c.get(Calendar.SECOND);
			
			String time =year+"-"+(month+1)+"-"+date+" "+hour+":"+minute+":"+second;
			
			ti.setModifydate(time);
			
			return dao.addchange(ti);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
