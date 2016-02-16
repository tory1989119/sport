package com.sport.filter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter {
	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();
		// 如果session不为空，则可以浏览其他页面
		String url = request.getServletPath();
		// 这里判断目录，后缀名，当然也可以写在web.xml中，用url-pattern进行拦截映射
		if ((!url.endsWith("/login.do")) && (!url.endsWith("/tologin.do"))) {
			if (session.getAttribute("tymanager") == null) {
				session.invalidate();
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script language='javascript' type='text/javascript'>");
				out.println("alert('由于你长时间没有操作,请你重新登录!');window.location.href='"+ request.getContextPath() + "/login/login.do'");
				out.println("</script>");
			} else {
				chain.doFilter(request, response);
			}
		} else {
			chain.doFilter(request, response);
		}

	}

	public void init(FilterConfig arg0) throws ServletException {

	}
}
