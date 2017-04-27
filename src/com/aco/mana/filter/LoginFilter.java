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
 * �ж��Ƿ��¼����������
 */
public class LoginFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		// ��������������Ҫ�õ�request,response,session����
		HttpServletRequest servletRequest = ( HttpServletRequest ) request;
		HttpServletResponse servletResponse = ( HttpServletResponse ) response;
		HttpSession session = servletRequest.getSession();
		
		// ����û������URI
		String path = servletRequest.getRequestURI();
		System.out.println(path);
		
		// ��session��ȡԱ��������Ϣ
		Admin existAdmin = (Admin)session.getAttribute("existAdmin");
		
		//��¼ҳ���������
		int checkPath = path.indexOf("/login");
			if (checkPath > 0) {
//				System.out.println("��¼ҳ�治�ù���");
				chain.doFilter(servletRequest, servletResponse);
				return;
			}
			//���û�л�ȡ��Ա��������ת����¼ҳ��
			if (null == existAdmin) {
//				System.out.println("û�е�¼��ת");
				servletResponse.sendRedirect("/graduate/page/login.jsp");
			} else {
				//��ȡ��Ա�����󣬼����˴�����
//				System.out.println("�ѵ�¼��������");
				chain.doFilter(servletRequest, servletResponse);
			}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}


}
