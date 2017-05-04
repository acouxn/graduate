package com.aco.mana.dao.impl;

import java.util.List;


import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aco.mana.dao.OutFurnitureDetailDao;
import com.aco.mana.domain.OutFurnitureDetail;
import com.opensymphony.xwork2.ActionContext;

public class OutFurnitureDetailDaoImpl extends HibernateDaoSupport implements OutFurnitureDetailDao{
	
	/**
	 * dao层查询销售详情单总记录数的方法
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
	 * dao层分页查询销售详情单
	 */
	@Override
	public List<OutFurnitureDetail> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(OutFurnitureDetail.class);
		List<OutFurnitureDetail> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize); 
		return list;
	}

	/**
	 * dao层保存销售详情单
	 */
	@Override
	public void save(OutFurnitureDetail outFurnitureDetail) {
		this.getHibernateTemplate().save(outFurnitureDetail);
	}
	
	/**
	 * dao层根据销售详情单ID查询销售详情单的方法
	 */
	@Override
	public OutFurnitureDetail findById(Integer oid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(OutFurnitureDetail.class, oid);
	}
	
	/**
	 * dao层根据销售详情单ID查询销售详情单的方法
	 */
	@Override
	public OutFurnitureDetail findByOid(String out_fid) {
		// TODO Auto-generated method stub
		//String hql = "from OutFurnitureDetail where out_fdid="+out_fid;
		return this.getHibernateTemplate().get(OutFurnitureDetail.class, out_fid);
	}
	/**
	 * Dao层修改销售详情单的方法
	 */
	@Override
	public void update(OutFurnitureDetail outFurnitureDetail) {
		// TODO Auto-generated method stub
		
		this.getHibernateTemplate().update(outFurnitureDetail);
	}
	
	/**
	 * Dao层删除销售详情单的方法
	 */
	@Override
	public void delete(OutFurnitureDetail outFurnitureDetail) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(outFurnitureDetail);
	}
	
	/**
	 * Dao层根据根据销售单id查询销售详情单的方法
	 */
	@Override
	public List<OutFurnitureDetail> findAllByOutfid(String out_fdid) {
		// TODO Auto-generated method stub
		String hql = "from OutFurnitureDetail where outFurniture.out_fid="+out_fdid;
		List<OutFurnitureDetail> outflist = this.getHibernateTemplate().find(hql);
		ActionContext.getContext().getValueStack().set("outflist",outflist);
		//System.out.println("4号订单数量"+foutlist.size()+"总货物数量"+foutlist.get(0).getOut_fdnum());
		if(outflist.size()>0){
			return outflist;
		}else{
			return null;
		}
	}
	
	/**
	 * Dao层根据仓库id查询销售详情单的方法
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
