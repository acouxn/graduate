package com.aco.mana.dao.impl;

import java.util.Arrays;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aco.mana.dao.FurnitureDao;
import com.aco.mana.domain.Furniture;
import com.aco.mana.domain.InFurniture;

/**
 * ��������Dao��ʵ����
 * @author Administrator
 *
 */
public class FurnitureDaoImpl extends HibernateDaoSupport implements FurnitureDao{

	/**
	 * dao���ѯ�����ܼ�¼���ķ���
	 */
	@Override
	public int findCount() {
		String hql = "select count(*) from Furniture";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	
	/**
	 * dao���ҳ��ѯ����
	 */
	@Override
	public List<Furniture> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Furniture.class);
		List<Furniture> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize); 
		return list;
	}
	
	/**
	 * dao�㱣�����
	 */
	@Override
	public void save(Furniture furniture) {
		this.getHibernateTemplate().save(furniture);
	}
	
	/**
	 * dao����ݻ���ID��ѯ����ķ���
	 */
	@Override
	public Furniture findById(Integer fid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Furniture.class, fid);
	}
	
	/**
	 * Dao���޸Ļ���ķ���
	 */
	@Override
	public void update(Furniture furniture) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(furniture);
	}
	
	/**
	 * Dao��ɾ������ķ���
	 */
	@Override
	public void delete(Furniture furniture) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(furniture);
	}
	
	/**
	 * Dao�в�ѯ���л���ķ���
	 */
	@Override
	public List<Furniture> finAll() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Furniture");
		
	}
	
	/**
	 * Dao�и��ݽ�����id��ѯ����ķ���
	 */
	@Override
	public List<Furniture> findAllByInid(InFurniture inFurniture) {
		// TODO Auto-generated method stub
		String hql = "select f from Furniture f left join f.inFurniture inf where inf.in_fid= ?";
		List<Furniture> flist = this.getHibernateTemplate().find(hql, inFurniture.getIn_fid());	
		//System.out.println("��������"+flist.size());
		//for(Furniture f:flist){
		//	System.out.println("�����Ҿ�"+f);
		//}
		return flist;
	}


}
