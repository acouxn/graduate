package com.aco.mana.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aco.mana.dao.InFurnitureDao;
import com.aco.mana.domain.InFurniture;

public class InFurnitureDaoImpl extends HibernateDaoSupport implements InFurnitureDao{
	
	/**
	 * dao层查询进货单总记录数的方法
	 */
	@Override
	public int findCount() {
		String hql = "select count(*) from InFurniture";//select count(*) from InFurniture inf left outer join inf.furniture
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	
	/**
	 * dao层分页查询进货单
	 */
	@Override
	public List<InFurniture> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(InFurniture.class);
		List<InFurniture> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize); 
		return list;
	}

	/**
	 * dao层保存进货单
	 */
	@Override
	public void save(InFurniture inFurniture) {
		this.getHibernateTemplate().save(inFurniture);
	}
	
	/**
	 * dao层根据进货单ID查询进货单的方法
	 */
	@Override
	public InFurniture findById(Integer iid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(InFurniture.class, iid);
	}
	
	/**
	 * Dao层修改进货单的方法
	 */
	@Override
	public void update(InFurniture inFurniture) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(inFurniture);
	}
	
	/**
	 * Dao层删除进货单的方法
	 */
	@Override
	public void delete(InFurniture inFurniture) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(inFurniture);
	}
}
