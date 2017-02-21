package com.bbs.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.bbs.entity.Topic;
import com.bbs.entity.Userinfo;
import com.bbs.form.TopicForm;
import com.bbs.form.UserinfoForm;
import com.bbs.service.TopicService;
import com.itany.factory.ObjectFactory;


public class TopicAction extends MappingDispatchAction {
	
	public ActionForward topic(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		TopicForm fm=(TopicForm)form;
		
		TopicService service=(TopicService)ObjectFactory.getObject("topicservice");
		
		List<Topic> list=service.findAll(fm.getPagenumber(),fm.getPagesize());
		
		request.setAttribute("topic",list);
		
		//获得total
		int count=service.total();
		request.setAttribute("count",count);
		
		request.setAttribute("fm",fm);
		
		return mapping.findForward("success");

	}
	
	public ActionForward addtop(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		TopicForm fm=(TopicForm)form;
		
		TopicService service=(TopicService)ObjectFactory.getObject("topicservice");
		int result=service.addtop(fm.getTi().getTopicid(),fm.getTi().getIstop());
		
		JSONArray array = JSONArray.fromObject(result);

		response.setHeader("content-type", "text/json;charset=utf-8");
		response.getWriter().print(array.toString());
		
		return null;
	}
	
	public ActionForward addgood(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		TopicForm fm=(TopicForm)form;
		
		TopicService service=(TopicService)ObjectFactory.getObject("topicservice");
		int result = service.addgood(fm.getTi().getTopicid(),fm.getTi().getIsgood());
		
		JSONArray array = JSONArray.fromObject(result);

		response.setHeader("content-type", "text/json;charset=utf-8");
		response.getWriter().print(array.toString());
		
		return null;
	}
	
	public ActionForward addmodify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		TopicForm fm=(TopicForm)form;
		
		TopicService service=(TopicService)ObjectFactory.getObject("topicservice");
		Topic result = service.addmodify(fm.getTi().getTopicid());
		
		JSONArray array = JSONArray.fromObject(result);

		response.setHeader("content-type", "text/json;charset=utf-8");
		response.getWriter().print(array.toString());
	
		return null;
	}
	
	public ActionForward adddelet(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		TopicForm fm=(TopicForm)form;
		
		TopicService service=(TopicService)ObjectFactory.getObject("topicservice");
		
		int result =service.adddelet(fm.getTi().getTopicid());
		
		JSONArray array = JSONArray.fromObject(result);

		response.setHeader("content-type", "text/json;charset=utf-8");
		response.getWriter().print(array.toString());
	
		return null;
	}
	
	public ActionForward addchange(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		TopicForm fm=(TopicForm)form;
		System.out.println(fm.getTi().getModifydate());
		System.out.println(request.getParameter("ti.modifydate"));
		TopicService service=(TopicService)ObjectFactory.getObject("topicservice");
		
		int result =service.addchange(fm.getTi());
		
		response.setHeader("content-type", "text/html;charset=utf-8");
		response.setHeader("refresh","1;url=findtopic.action");
		System.out.println(result);
		return null;
	}
}
