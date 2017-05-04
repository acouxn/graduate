package com.aco.mana.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aco.mana.dao.OutFurnitureDao;
import com.aco.mana.domain.OutFurniture;

/**
 * ���۵������Dao��ʵ����
 * @author Administrator
 *
 */
public class OutFurnitureDaoImpl extends HibernateDaoSupport implements OutFurnitureDao{

	/**
	 * dao���ѯ���۵��ܼ�¼���ķ���
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
	 * dao���ҳ��ѯ���۵�
	 */
	@Override
	public List<OutFurniture> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(OutFurniture.class);
		List<OutFurniture> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize); 
		return list;
	}
	
	/**
	 * dao�㱣�����۵�
	 */
	@Override
	public void save(OutFurniture outFurniture) {
		this.getHibernateTemplate().save(outFurniture);
	}
	
	/**
	 * dao��������۵�ID��ѯ���۵��ķ���
	 */
	@Override
	public OutFurniture findById(Integer fid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(OutFurniture.class, fid);
	}
	
	/**
	 * Dao���޸����۵��ķ���
	 */
	@Override
	public void update(OutFurniture outFurniture) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(outFurniture);
	}
	
	/**
	 * Dao��ɾ�����۵��ķ���
	 */
	@Override
	public void delete(OutFurniture outFurniture) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(outFurniture);
	}
	
	/**
	 * Dao�в�ѯ�������۵��ķ���
	 */
	@Override
	public List<OutFurniture> finAll() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from OutFurniture");
		
	}

	
}
