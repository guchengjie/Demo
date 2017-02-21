package com.itany.bbs.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncodingRequest extends HttpServletRequestWrapper {
	private String charset;

	public EncodingRequest(HttpServletRequest request,String charset) {
		super(request);		
		this.charset=charset;
	}
	
	
	@Override	
	public String getParameter(String name) {		
		return encoding(super.getParameter(name));
	}

	
	@Override
	public String[] getParameterValues(String name) {
		String []values=super.getParameterValues(name);
		for (int i = 0;values!=null && i < values.length; i++) {
			values[i]=encoding(values[i]);
		}
		return values;
	}
	
	
	private String encoding(String src){
		if(src==null)
			return null;
		try {
			return new String(src.getBytes("ISO8859-1"),charset);
		} catch (UnsupportedEncodingException e) {
			return src;
		}
	}

}
