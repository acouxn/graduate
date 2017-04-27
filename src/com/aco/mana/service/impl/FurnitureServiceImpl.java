package com.aco.mana.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.aco.mana.dao.FurnitureDao;
import com.aco.mana.domain.Furniture;
import com.aco.mana.domain.InFurniture;
import com.aco.mana.domain.PageBean;
import com.aco.mana.service.FurnitureService;

/**
 * 业务层实现货物管理的实现类
 * @author Administrator
 *
 */
@Transactional
public class FurnitureServiceImpl implements FurnitureService{
	
	//注入Dao层的类
	FurnitureDao furnitureDao;

	public void setFurnitureDao(FurnitureDao furnitureDao) {
		this.furnitureDao = furnitureDao;
	}
	
	/**
	 *业务层分页查询货物的方法
	 */
	@Override
	public PageBean<Furniture> findByPage(Integer currPage) {
		PageBean<Furniture> pageBean =new PageBean<Furniture>();
		//封装当前的页面
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//封装总的记录数
		int totalCount = furnitureDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage-1)*pageSize;
		List<Furniture> list = furnitureDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}
	
	/**
	 * 业务层保存货物的方法
	 */
	@Override
	public void save(Furniture furniture) {
		// TODO Auto-generated method stub
		furnitureDao.save(furniture);
	}
	
	/**
	 * 业务层根据货物ID查询货物的方法
	 */
	@Override
	public Furniture findById(Integer fid) {
		// TODO Auto-generated method stub
		return furnitureDao.findById(fid);
	}
	
	/**
	 * 业务层更新货物的方法
	 */
	@Override
	public void update(Furniture furniture) {
		// TODO Auto-generated method stub
		furnitureDao.update(furniture);
	}
	
	/**
	 * 业务层删除货物的方法
	 */
	@Override
	public void delete(Furniture furniture) {
		// TODO Auto-generated method stub
		furnitureDao.delete(furniture);
	}
	
	/**
	 * 业务层查询所有货物的方法
	 */
	@Override
	public List<Furniture> findAll() {
		// TODO Auto-generated method stub
		return furnitureDao.finAll();
	}
	
	/**
	 * 业务层根据订单id查询货物的方法
	 */
	@Override
	public List<Furniture> findAllByInid(InFurniture inFurniture) {
		// TODO Auto-generated method stub
		List<Furniture> flist = furnitureDao.findAllByInid(inFurniture);

		return flist;
	}

}
