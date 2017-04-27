package com.aco.mana.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.aco.mana.dao.StorehouseDao;
import com.aco.mana.domain.Furniture;
import com.aco.mana.domain.PageBean;
import com.aco.mana.domain.Storehouse;
import com.aco.mana.service.StorehouseService;

/**
 * 业务层实现仓库的管理类
 * @author Administrator
 *
 */
@Transactional
public class StorehouseServiceImpl implements StorehouseService{
	
	//注入Dao层的类
	StorehouseDao storehouseDao;
	
	public void setStorehouseDao(StorehouseDao storehouseDao) {
		this.storehouseDao = storehouseDao;
	}

	@Override
	public PageBean<Storehouse> findByPage(Integer currPage) {
		PageBean<Storehouse> pageBean =new PageBean<Storehouse>();
		//封装当前的页面
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//封装总的记录数
		int totalCount = storehouseDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage-1)*pageSize;
		List<Storehouse> list = storehouseDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}
	
	/**
	 * 业务层保存仓库的方法
	 */
	@Override
	public void save(Storehouse storehouse) {
		// TODO Auto-generated method stub
		storehouseDao.save(storehouse);
	}
	
	/**
	 * 业务层根据仓库ID查询仓库的方法
	 */
	@Override
	public Storehouse findById(Integer sid) {
		// TODO Auto-generated method stub
		return storehouseDao.findById(sid);
	}
	
	/**
	 * 业务层更新仓库的方法
	 */
	@Override
	public void update(Storehouse storehouse) {
		// TODO Auto-generated method stub
		storehouseDao.update(storehouse);
	}
	
	/**
	 * 业务层删除仓库的方法
	 */
	@Override
	public void delete(Storehouse storehouse) {
		// TODO Auto-generated method stub
		storehouseDao.delete(storehouse);
	}
	
	/**
	 * 业务层查询所有仓库的方法
	 */
	@Override
	public List<Storehouse> findAll() {
		// TODO Auto-generated method stub
		return storehouseDao.finAll();
	}
}
