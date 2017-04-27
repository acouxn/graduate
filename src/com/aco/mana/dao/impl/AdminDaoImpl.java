package com.aco.mana.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aco.mana.dao.AdminDao;
import com.aco.mana.domain.Admin;

/**
 * 
 * @author Aco	
 * ����Ա�����Dao��ʵ����
 */
public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao{

	/**
	 * Dao��ĵ�¼����
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
