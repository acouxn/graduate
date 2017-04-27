package com.aco.mana.action;

import com.aco.mana.domain.Admin;
import com.aco.mana.service.AdminService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @author Aco
 * ����Ա�����Ation��
 */
public class AdminAction extends ActionSupport implements ModelDriven<Admin> {
	
	//ģ�Ͷ���ʹ�õĶ���
	private Admin admin = new Admin();
	//ע��ҵ�����
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
	 * ��¼ִ�еķ���
	 */
	public String login() {
		// ����ҵ������
		Admin existAdmin = adminService.login(admin);
		if (null == existAdmin) {
			// ��¼ʧ��
			this.addActionError("�û������������");
			return INPUT;
		} else {
			// ��¼�ɹ�
			ActionContext.getContext().getSession()
					.put("existAdmin", existAdmin);
			return SUCCESS;
		}
	}
	
	/**
	 * ע��ִ�еķ���
	 */
	public String logout(){
		ActionContext.getContext().getSession().remove("existAdmin");
		return "logoutSuccess";
	}
}
