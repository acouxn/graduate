package com.aco.mana.dao.impl;

import java.util.List;


import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aco.mana.dao.OutFurnitureDetailDao;
import com.aco.mana.domain.OutFurnitureDetail;
import com.opensymphony.xwork2.ActionContext;

public class OutFurnitureDetailDaoImpl extends HibernateDaoSupport implements OutFurnitureDetailDao{
	
	/**
	 * dao���ѯ�������鵥�ܼ�¼���ķ���
	 */
	@Override
	public int findCount() {
		String hql = "select count(*) from OutFurnitureDetail";//select count(*) from InFurniture inf left outer join inf.furniture
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	
	/**
	 * dao���ҳ��ѯ�������鵥
	 */
	@Override
	public List<OutFurnitureDetail> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(OutFurnitureDetail.class);
		List<OutFurnitureDetail> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize); 
		return list;
	}

	/**
	 * dao�㱣���������鵥
	 */
	@Override
	public void save(OutFurnitureDetail outFurnitureDetail) {
		this.getHibernateTemplate().save(outFurnitureDetail);
	}
	
	/**
	 * dao������������鵥ID��ѯ�������鵥�ķ���
	 */
	@Override
	public OutFurnitureDetail findById(Integer oid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(OutFurnitureDetail.class, oid);
	}
	
	/**
	 * dao������������鵥ID��ѯ�������鵥�ķ���
	 */
	@Override
	public OutFurnitureDetail findByOid(String out_fid) {
		// TODO Auto-generated method stub
		//String hql = "from OutFurnitureDetail where out_fdid="+out_fid;
		return this.getHibernateTemplate().get(OutFurnitureDetail.class, out_fid);
	}
	/**
	 * Dao���޸��������鵥�ķ���
	 */
	@Override
	public void update(OutFurnitureDetail outFurnitureDetail) {
		// TODO Auto-generated method stub
		
		this.getHibernateTemplate().update(outFurnitureDetail);
	}
	
	/**
	 * Dao��ɾ���������鵥�ķ���
	 */
	@Override
	public void delete(OutFurnitureDetail outFurnitureDetail) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(outFurnitureDetail);
	}
	
	/**
	 * Dao����ݸ������۵�id��ѯ�������鵥�ķ���
	 */
	@Override
	public List<OutFurnitureDetail> findAllByOutfid(String out_fdid) {
		// TODO Auto-generated method stub
		String hql = "from OutFurnitureDetail where outFurniture.out_fid="+out_fdid;
		List<OutFurnitureDetail> outflist = this.getHibernateTemplate().find(hql);
		ActionContext.getContext().getValueStack().set("outflist",outflist);
		//System.out.println("4�Ŷ�������"+foutlist.size()+"�ܻ�������"+foutlist.get(0).getOut_fdnum());
		if(outflist.size()>0){
			return outflist;
		}else{
			return null;
		}
	}
	
	/**
	 * Dao����ݲֿ�id��ѯ�������鵥�ķ���
	 */
	@Override
	public List<OutFurnitureDetail> findAllBySid(String sid) {
		// TODO Auto-generated method stub
		String hql = "from OutFurnitureDetail where storehouse.sid="+sid;
		List<OutFurnitureDetail> list = this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list;
		}else{
			return null;
		}
	}



}
