package com.aco.mana.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aco.mana.dao.AdminDao;
import com.aco.mana.domain.Admin;

/**
 * 
 * @author Aco	
 * 管理员管理的Dao层实现类
 */
public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao{

	/**
	 * Dao层的登录方法
	 */
	@Override
	public Admin findByUsernameAndPassword(Admin admin) {
		// TODO Auto-generated method stub
		String hql = "from Admin" +
				" where username = ? and password = ?";
		List<Admin> list = this.getHibernateTemplate().find(hql,admin.getUsername(),admin.getPassword());
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
