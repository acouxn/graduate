package com.aco.mana.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aco.mana.dao.StorehouseDao;
import com.aco.mana.domain.Furniture;
import com.aco.mana.domain.Storehouse;

/**
 * �ֿ�����Dao��ʵ����
 * @author Administrator
 *
 */
public class StorehouseDaoImpl extends HibernateDaoSupport implements StorehouseDao{
	
	/**
	 * dao���ѯ�����ܼ�¼���ķ���
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
	 * dao���ҳ��ѯ�ֿ�
	 */
	@Override
	public List<Storehouse> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Storehouse.class);
		List<Storehouse> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize); 
		return list;
	}

	/**
	 * dao�㱣��ֿ�
	 */
	@Override
	public void save(Storehouse storehouse) {
		this.getHibernateTemplate().save(storehouse);
	}
	
	/**
	 * dao����ݻ���ID��ѯ�ֿ�ķ���
	 */
	@Override
	public Storehouse findById(Integer sid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Storehouse.class, sid);
	}
	
	/**
	 * Dao���޸Ĳֿ�ķ���
	 */
	@Override
	public void update(Storehouse storehouse) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(storehouse);
	}
	
	/**
	 * Dao��ɾ���ֿ�ķ���
	 */
	@Override
	public void delete(Storehouse storehouse) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(storehouse);
	}
	
	/**
	 * Dao���ѯ���вֿ�ķ���
	 */
	@Override
	public List<Storehouse> finAll() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Storehouse");
	}

}
