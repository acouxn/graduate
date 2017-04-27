package com.aco.mana.action;

import com.aco.mana.domain.Admin;
import com.aco.mana.service.AdminService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @author Aco
 * 管理员管理的Ation类
 */
public class AdminAction extends ActionSupport implements ModelDriven<Admin> {
	
	//模型对象使用的对象
	private Admin admin = new Admin();
	//注入业务层类
	private AdminService adminService;

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	@Override
	public Admin getModel() {
		// TODO Auto-generated method stub
		return admin;
	}

	/**
	 * 登录执行的方法
	 */
	public String login() {
		// 调用业务层的类
		Admin existAdmin = adminService.login(admin);
		if (null == existAdmin) {
			// 登录失败
			this.addActionError("用户名或密码错误！");
			return INPUT;
		} else {
			// 登录成功
			ActionContext.getContext().getSession()
					.put("existAdmin", existAdmin);
			return SUCCESS;
		}
	}
	
	/**
	 * 注销执行的方法
	 */
	public String logout(){
		ActionContext.getContext().getSession().remove("existAdmin");
		return "logoutSuccess";
	}
}
