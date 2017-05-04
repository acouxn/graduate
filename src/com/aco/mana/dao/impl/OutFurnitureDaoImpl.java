package com.aco.mana.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aco.mana.dao.OutFurnitureDao;
import com.aco.mana.domain.OutFurniture;

/**
 * 销售单管理的Dao层实现类
 * @author Administrator
 *
 */
public class OutFurnitureDaoImpl extends HibernateDaoSupport implements OutFurnitureDao{

	/**
	 * dao层查询销售单总记录数的方法
	 */
	@Override
	public int findCount() {
		String hql = "select count(*) from OutFurniture";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	
	/**
	 * dao层分页查询销售单
	 */
	@Override
	public List<OutFurniture> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(OutFurniture.class);
		List<OutFurniture> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize); 
		return list;
	}
	
	/**
	 * dao层保存销售单
	 */
	@Override
	public void save(OutFurniture outFurniture) {
		this.getHibernateTemplate().save(outFurniture);
	}
	
	/**
	 * dao层根据销售单ID查询销售单的方法
	 */
	@Override
	public OutFurniture findById(Integer fid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(OutFurniture.class, fid);
	}
	
	/**
	 * Dao层修改销售单的方法
	 */
	@Override
	public void update(OutFurniture outFurniture) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(outFurniture);
	}
	
	/**
	 * Dao层删除销售单的方法
	 */
	@Override
	public void delete(OutFurniture outFurniture) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(outFurniture);
	}
	
	/**
	 * Dao中查询所有销售单的方法
	 */
	@Override
	public List<OutFurniture> finAll() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from OutFurniture");
		
	}

	
}
