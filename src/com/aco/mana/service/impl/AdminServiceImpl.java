package com.aco.mana.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.aco.mana.dao.AdminDao;
import com.aco.mana.domain.Admin;
import com.aco.mana.service.AdminService;

/**
 * 
 * @author Administrator
 * 管理员管理的业务层实现类
 */
@Transactional
public class AdminServiceImpl implements AdminService{

	AdminDao adminDao;
	
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	/**
	 * 业务层登录方法
	 */
	@Override
	public Admin login(Admin admin) {
		// TODO Auto-generated method stub
	    Admin existAdmin = adminDao.findByUsernameAndPassword(admin);
		return existAdmin;
	}

}
