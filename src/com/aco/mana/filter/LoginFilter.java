package com.aco.mana.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aco.mana.domain.Admin;

/**
 * 
 * @author Administrator
 * 判断是否登录的拦截器类
 */
public class LoginFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		// 获得在下面代码中要用的request,response,session对象
		HttpServletRequest servletRequest = ( HttpServletRequest ) request;
		HttpServletResponse servletResponse = ( HttpServletResponse ) response;
		HttpSession session = servletRequest.getSession();
		
		// 获得用户请求的URI
		String path = servletRequest.getRequestURI();
		System.out.println(path);
		
		// 从session里取员工工号信息
		Admin existAdmin = (Admin)session.getAttribute("existAdmin");
		
		//登录页面无需过滤
		int checkPath = path.indexOf("/login");
			if (checkPath > 0) {
//				System.out.println("登录页面不用过滤");
				chain.doFilter(servletRequest, servletResponse);
				return;
			}
			//如果没有获取到员工对象，跳转到登录页面
			if (null == existAdmin) {
//				System.out.println("没有登录跳转");
				servletResponse.sendRedirect("/graduate/page/login.jsp");
			} else {
				//获取到员工对象，继续此次请求
//				System.out.println("已登录继续请求");
				chain.doFilter(servletRequest, servletResponse);
			}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}


}
