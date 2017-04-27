package com.aco.mana.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aco.mana.dao.StorehouseDao;
import com.aco.mana.domain.Furniture;
import com.aco.mana.domain.Storehouse;

/**
 * 仓库管理的Dao层实现类
 * @author Administrator
 *
 */
public class StorehouseDaoImpl extends HibernateDaoSupport implements StorehouseDao{
	
	/**
	 * dao层查询货物总记录数的方法
	 */
	@Override
	public int findCount() {
		String hql = "select count(*) from Storehouse";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	
	/**
	 * dao层分页查询仓库
	 */
	@Override
	public List<Storehouse> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Storehouse.class);
		List<Storehouse> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize); 
		return list;
	}

	/**
	 * dao层保存仓库
	 */
	@Override
	public void save(Storehouse storehouse) {
		this.getHibernateTemplate().save(storehouse);
	}
	
	/**
	 * dao层根据货物ID查询仓库的方法
	 */
	@Override
	public Storehouse findById(Integer sid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Storehouse.class, sid);
	}
	
	/**
	 * Dao层修改仓库的方法
	 */
	@Override
	public void update(Storehouse storehouse) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(storehouse);
	}
	
	/**
	 * Dao层删除仓库的方法
	 */
	@Override
	public void delete(Storehouse storehouse) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(storehouse);
	}
	
	/**
	 * Dao层查询所有仓库的方法
	 */
	@Override
	public List<Storehouse> finAll() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Storehouse");
	}

}
