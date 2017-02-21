package com.itany.bbs.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CharactorFilter implements Filter {
	private String charSet;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		if ("POST".equalsIgnoreCase(request.getMethod())) {
			request.setCharacterEncoding(charSet);
		} else {
			req = new EncodingRequest(request, charSet);
		}
		chain.doFilter(req, resp);

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		charSet = config.getInitParameter("Charset");
		if (charSet == null || charSet.trim().equals(""))
			charSet = "UTF-8";
	}

}