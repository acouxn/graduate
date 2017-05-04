package com.aco.mana.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aco.mana.dao.ClientDao;
import com.aco.mana.domain.Client;

/**
 * 客户信息管理的Dao层实现类
 * 
 * @author Administrator
 * 
 */
public class ClientDaoImpl extends HibernateDaoSupport implements ClientDao {

	/**
	 * dao层查询客户信息总记录数的方法
	 */
	@Override
	public int findCount() {
		String hql = "select count(*) from Client";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	/**
	 * dao层分页查询客户信息
	 */
	@Override
	public List<Client> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Client.class);
		List<Client> list = this.getHibernateTemplate().findByCriteria(
				criteria, begin, pageSize);
		return list;
	}

	/**
	 * dao层保存客户信息
	 */
	@Override
	public void save(Client client) {
		this.getHibernateTemplate().save(client);
	}

	/**
	 * dao层根据客户信息ID查询客户信息的方法
	 */
	@Override
	public Client findById(Integer cid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Client.class, cid);
	}

	/**
	 * Dao层修改客户信息的方法
	 */
	@Override
	public void update(Client client) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(client);
	}

	/**
	 * Dao层删除客户信息的方法
	 */
	@Override
	public void delete(Client client) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(client);
	}
	
	/**
	 * Dao层查询所有客户信息的方法
	 */
	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Client");
	}

}
