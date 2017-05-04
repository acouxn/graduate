package com.aco.mana.dao.impl;

import java.util.List;

import javax.security.auth.message.callback.SecretKeyCallback.Request;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aco.mana.dao.InFurnitureDetailDao;
import com.aco.mana.domain.InFurnitureDetail;

public class InFurnitureDetailDaoImpl extends HibernateDaoSupport implements InFurnitureDetailDao{
	
	/**
	 * dao���ѯ�������ܼ�¼���ķ���
	 */
	@Override
	public int findCount() {
		String hql = "select count(*) from InFurnitureDetail";//select count(*) from InFurniture inf left outer join inf.furniture
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
	public List<InFurnitureDetail> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(InFurnitureDetail.class);
		List<InFurnitureDetail> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize); 
		return list;
	}

	/**
	 * dao�㱣�������
	 */
	@Override
	public void save(InFurnitureDetail inFurnitureDetail) {
		this.getHibernateTemplate().save(inFurnitureDetail);
	}
	
	/**
	 * dao����ݽ�����ID��ѯ�������ķ���
	 */
	@Override
	public InFurnitureDetail findById(Integer iid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(InFurnitureDetail.class, iid);
	}
	
	/**
	 * Dao���޸Ľ������ķ���
	 */
	@Override
	public void update(InFurnitureDetail inFurnitureDetail) {
		// TODO Auto-generated method stub
		
		this.getHibernateTemplate().update(inFurnitureDetail);
	}
	
	/**
	 * Dao��ɾ���������ķ���
	 */
	@Override
	public void delete(InFurnitureDetail inFurnitureDetail) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(inFurnitureDetail);
	}
	
	/**
	 * Dao����ݸ��ݽ�����id��ѯ�����굥�ķ���
	 */
	@Override
	public List<InFurnitureDetail> findAllByInfid(String in_fid) {
		// TODO Auto-generated method stub
		String hql = "from InFurnitureDetail where inFurniture.in_fid="+in_fid;
		List<InFurnitureDetail> finlist = this.getHibernateTemplate().find(hql);
		//System.out.println("4�Ŷ�������"+finlist.size()+"�ܻ�������"+finlist.get(0).getIn_fdnum());
		if(finlist.size()>0){
			return finlist;
		}else{
			return null;
		}
	}
	
	/**
	 * Dao����ݲֿ�id��ѯ�����굥�ķ���
	 */
	@Override
	public List<InFurnitureDetail> findAllBySid(String sid) {
		// TODO Auto-generated method stub
		String hql = "from InFurnitureDetail where storehouse.sid="+sid;
		List<InFurnitureDetail> list = this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list;
		}else{
			return null;
		}
	}
	
	/**
	 * Dao����ݲֿ�id�ͼҾ�id��ѯ�����굥�ķ���
	 */
	@Override
	public InFurnitureDetail findBySidAndFid(String sid, String fid) {
		// TODO Auto-generated method stub
		String hql = "from InFurnitureDetail where storehouse.sid="+sid+" and furniture.fid="+fid;
		List<InFurnitureDetail> list =  this.getHibernateTemplate().find(hql);
		return list.get(0);
	}
	
	/**
	 * Dao���ѯ���н����굥�ķ���
	 */
	@Override
	public List<InFurnitureDetail> findAll() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from InFurnitureDetail");
	}

}
