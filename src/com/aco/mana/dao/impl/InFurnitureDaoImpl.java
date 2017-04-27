package com.aco.mana.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aco.mana.dao.InFurnitureDao;
import com.aco.mana.domain.InFurniture;

public class InFurnitureDaoImpl extends HibernateDaoSupport implements InFurnitureDao{
	
	/**
	 * dao���ѯ�������ܼ�¼���ķ���
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
	 * dao���ҳ��ѯ������
	 */
	@Override
	public List<InFurniture> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(InFurniture.class);
		List<InFurniture> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize); 
		return list;
	}

	/**
	 * dao�㱣�������
	 */
	@Override
	public void save(InFurniture inFurniture) {
		this.getHibernateTemplate().save(inFurniture);
	}
	
	/**
	 * dao����ݽ�����ID��ѯ�������ķ���
	 */
	@Override
	public InFurniture findById(Integer iid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(InFurniture.class, iid);
	}
	
	/**
	 * Dao���޸Ľ������ķ���
	 */
	@Override
	public void update(InFurniture inFurniture) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(inFurniture);
	}
	
	/**
	 * Dao��ɾ���������ķ���
	 */
	@Override
	public void delete(InFurniture inFurniture) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(inFurniture);
	}
}
