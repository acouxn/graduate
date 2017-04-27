package com.aco.mana.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.aco.mana.dao.AdminDao;
import com.aco.mana.domain.Admin;
import com.aco.mana.service.AdminService;

/**
 * 
 * @author Administrator
 * ����Ա�����ҵ���ʵ����
 */
@Transactional
public class AdminServiceImpl implements AdminService{

	AdminDao adminDao;
	
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	/**
	 * ҵ����¼����
	 */
	@Override
	public Admin login(Admin admin) {
		// TODO Auto-generated method stub
	    Admin existAdmin = adminDao.findByUsernameAndPassword(admin);
		return existAdmin;
	}

}
