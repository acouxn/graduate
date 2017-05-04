package com.aco.mana.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.aco.mana.dao.OutFurnitureDao;
import com.aco.mana.domain.OutFurniture;
import com.aco.mana.domain.PageBean;
import com.aco.mana.service.OutFurnitureService;

/**
 * 业务层实现销售单管理的实现类
 * @author Administrator
 *
 */
@Transactional
public class OutFurnitureServiceImpl implements OutFurnitureService{
	
	//注入Dao层的类
	OutFurnitureDao outFurnitureDao;

	public void setOutFurnitureDao(OutFurnitureDao outFurnitureDao) {
		this.outFurnitureDao = outFurnitureDao;
	}
	
	/**
	 *业务层分页查询销售单的方法
	 */
	@Override
	public PageBean<OutFurniture> findByPage(Integer currPage) {
		PageBean<OutFurniture> pageBean =new PageBean<OutFurniture>();
		//封装当前的页面
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//封装总的记录数
		int totalCount = outFurnitureDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage-1)*pageSize;
		List<OutFurniture> list = outFurnitureDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}
	
	/**
	 * 业务层保存销售单的方法
	 */
	@Override
	public void save(OutFurniture outFurniture) {
		// TODO Auto-generated method stub
		outFurnitureDao.save(outFurniture);
	}
	
	/**
	 * 业务层根据销售单ID查询销售单的方法
	 */
	@Override
	public OutFurniture findById(Integer fid) {
		// TODO Auto-generated method stub
		return outFurnitureDao.findById(fid);
	}
	
	/**
	 * 业务层更新销售单的方法
	 */
	@Override
	public void update(OutFurniture outFurniture) {
		// TODO Auto-generated method stub
		outFurnitureDao.update(outFurniture);
	}
	
	/**
	 * 业务层删除销售单的方法
	 */
	@Override
	public void delete(OutFurniture outFurniture) {
		// TODO Auto-generated method stub
		outFurnitureDao.delete(outFurniture);
	}
	
	/**
	 * 业务层查询所有销售单的方法
	 */
	@Override
	public List<OutFurniture> findAll() {
		// TODO Auto-generated method stub
		return outFurnitureDao.finAll();
	}
	
	
}
