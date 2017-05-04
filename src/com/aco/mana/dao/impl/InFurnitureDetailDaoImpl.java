package com.aco.mana.dao.impl;

import java.util.List;

import javax.security.auth.message.callback.SecretKeyCallback.Request;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aco.mana.dao.InFurnitureDetailDao;
import com.aco.mana.domain.InFurnitureDetail;

public class InFurnitureDetailDaoImpl extends HibernateDaoSupport implements InFurnitureDetailDao{
	
	/**
	 * dao层查询进货单总记录数的方法
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
	 * dao层分页查询进货单
	 */
	@Override
	public List<InFurnitureDetail> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(InFurnitureDetail.class);
		List<InFurnitureDetail> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize); 
		return list;
	}

	/**
	 * dao层保存进货单
	 */
	@Override
	public void save(InFurnitureDetail inFurnitureDetail) {
		this.getHibernateTemplate().save(inFurnitureDetail);
	}
	
	/**
	 * dao层根据进货单ID查询进货单的方法
	 */
	@Override
	public InFurnitureDetail findById(Integer iid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(InFurnitureDetail.class, iid);
	}
	
	/**
	 * Dao层修改进货单的方法
	 */
	@Override
	public void update(InFurnitureDetail inFurnitureDetail) {
		// TODO Auto-generated method stub
		
		this.getHibernateTemplate().update(inFurnitureDetail);
	}
	
	/**
	 * Dao层删除进货单的方法
	 */
	@Override
	public void delete(InFurnitureDetail inFurnitureDetail) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(inFurnitureDetail);
	}
	
	/**
	 * Dao层根据根据进货单id查询进货详单的方法
	 */
	@Override
	public List<InFurnitureDetail> findAllByInfid(String in_fid) {
		// TODO Auto-generated method stub
		String hql = "from InFurnitureDetail where inFurniture.in_fid="+in_fid;
		List<InFurnitureDetail> finlist = this.getHibernateTemplate().find(hql);
		//System.out.println("4号订单数量"+finlist.size()+"总货物数量"+finlist.get(0).getIn_fdnum());
		if(finlist.size()>0){
			return finlist;
		}else{
			return null;
		}
	}
	
	/**
	 * Dao层根据仓库id查询进货详单的方法
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
	 * Dao层根据仓库id和家具id查询进货详单的方法
	 */
	@Override
	public InFurnitureDetail findBySidAndFid(String sid, String fid) {
		// TODO Auto-generated method stub
		String hql = "from InFurnitureDetail where storehouse.sid="+sid+" and furniture.fid="+fid;
		List<InFurnitureDetail> list =  this.getHibernateTemplate().find(hql);
		return list.get(0);
	}
	
	/**
	 * Dao层查询所有进货详单的方法
	 */
	@Override
	public List<InFurnitureDetail> findAll() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from InFurnitureDetail");
	}

}
