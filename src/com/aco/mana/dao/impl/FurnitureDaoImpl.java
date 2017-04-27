package com.aco.mana.dao.impl;

import java.util.Arrays;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aco.mana.dao.FurnitureDao;
import com.aco.mana.domain.Furniture;
import com.aco.mana.domain.InFurniture;

/**
 * 货物管理的Dao层实现类
 * @author Administrator
 *
 */
public class FurnitureDaoImpl extends HibernateDaoSupport implements FurnitureDao{

	/**
	 * dao层查询货物总记录数的方法
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
	 * dao层分页查询货物
	 */
	@Override
	public List<Furniture> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Furniture.class);
		List<Furniture> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize); 
		return list;
	}
	
	/**
	 * dao层保存货物
	 */
	@Override
	public void save(Furniture furniture) {
		this.getHibernateTemplate().save(furniture);
	}
	
	/**
	 * dao层根据货物ID查询货物的方法
	 */
	@Override
	public Furniture findById(Integer fid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Furniture.class, fid);
	}
	
	/**
	 * Dao层修改货物的方法
	 */
	@Override
	public void update(Furniture furniture) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(furniture);
	}
	
	/**
	 * Dao层删除货物的方法
	 */
	@Override
	public void delete(Furniture furniture) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(furniture);
	}
	
	/**
	 * Dao中查询所有货物的方法
	 */
	@Override
	public List<Furniture> finAll() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Furniture");
		
	}
	
	/**
	 * Dao中根据进货单id查询货物的方法
	 */
	@Override
	public List<Furniture> findAllByInid(InFurniture inFurniture) {
		// TODO Auto-generated method stub
		String hql = "select f from Furniture f left join f.inFurniture inf where inf.in_fid= ?";
		List<Furniture> flist = this.getHibernateTemplate().find(hql, inFurniture.getIn_fid());	
		//System.out.println("货物数量"+flist.size());
		//for(Furniture f:flist){
		//	System.out.println("订单家具"+f);
		//}
		return flist;
	}


}
