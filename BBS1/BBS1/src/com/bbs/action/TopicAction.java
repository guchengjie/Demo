package com.bbs.action;

import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.bbs.entity.Topic;
import com.bbs.service.TopicService;
import com.itany.factory.ObjectFactory;


public class TopicAction extends MappingDispatchAction {
	
	public ActionForward fatie(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		TopicService service=(TopicService)ObjectFactory.getObject("topicservice");
		
		List<Topic> list=service.findAll();
		
		
		
		
		
	}
}
