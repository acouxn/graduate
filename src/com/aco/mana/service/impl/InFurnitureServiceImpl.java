package com.aco.mana.service.impl;

import java.util.List;

import com.aco.mana.dao.InFurnitureDao;
import com.aco.mana.domain.InFurniture;
import com.aco.mana.domain.PageBean;
import com.aco.mana.service.InFurnitureService;

/**
 * 业务层进货单的实现类
 * @author Administrator
 *
 */
public class InFurnitureServiceImpl implements InFurnitureService{

	//注入Dao层的类
		InFurnitureDao inFurnitureDao;
		
		public void setInFurnitureDao(InFurnitureDao inFurnitureDao) {
			this.inFurnitureDao = inFurnitureDao;
		}

		@Override
		public PageBean<InFurniture> findByPage(Integer currPage) {
			PageBean<InFurniture> pageBean =new PageBean<InFurniture>();
			//封装当前的页面
			pageBean.setCurrPage(currPage);
			//封装每页显示的记录数
			int pageSize = 3;
			pageBean.setPageSize(pageSize);
			//封装总的记录数
			int totalCount = inFurnitureDao.findCount();
			pageBean.setTotalCount(totalCount);
			//封装总页数
			double tc = totalCount;
			Double num = Math.ceil(tc/pageSize);
			pageBean.setTotalPage(num.intValue());
			//封装每页显示的数据
			int begin = (currPage-1)*pageSize;
			List<InFurniture> list = inFurnitureDao.findByPage(begin,pageSize);
			//for(InFurniture inf:list){
			//		System.out.println("111111111111"+inf.getNum());
			//	}
			pageBean.setList(list);
			
			return pageBean;
		}
		
		/**
		 * 业务层保存进货单的方法
		 */
		@Override
		public void save(InFurniture inFurniture) {
			// TODO Auto-generated method stub
			inFurnitureDao.save(inFurniture);
		}
		
		/**
		 * 业务层根据进货单ID查询进货单的方法
		 */
		@Override
		public InFurniture findById(Integer iid) {
			// TODO Auto-generated method stub
			return inFurnitureDao.findById(iid);
		}
		
		/**
		 * 业务层更新进货单的方法
		 */
		@Override
		public void update(InFurniture inFurniture) {
			// TODO Auto-generated method stub
			inFurnitureDao.update(inFurniture);
		}
		
		/**
		 * 业务层删除进货单的方法
		 */
		@Override
		public void delete(InFurniture inFurniture) {
			// TODO Auto-generated method stub
			inFurnitureDao.delete(inFurniture);
		}
		
}
