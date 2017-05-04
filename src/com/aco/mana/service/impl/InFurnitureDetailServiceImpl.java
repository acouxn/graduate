package com.aco.mana.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.aco.mana.dao.InFurnitureDetailDao;
import com.aco.mana.domain.InFurnitureDetail;
import com.aco.mana.domain.PageBean;
import com.aco.mana.service.InFurnitureDetailService;

/**
 * 业务层进货单的实现类
 * @author Administrator
 *
 */
@Transactional
public class InFurnitureDetailServiceImpl implements InFurnitureDetailService{

	//注入Dao层的类
		InFurnitureDetailDao inFurnitureDetailDao;

		public void setInFurnitureDetailDao(InFurnitureDetailDao inFurnitureDetailDao) {
			this.inFurnitureDetailDao = inFurnitureDetailDao;
		}

		@Override
		public PageBean<InFurnitureDetail> findByPage(Integer currPage) {
			PageBean<InFurnitureDetail> pageBean =new PageBean<InFurnitureDetail>();
			//封装当前的页面
			pageBean.setCurrPage(currPage);
			//封装每页显示的记录数
			int pageSize = 3;
			pageBean.setPageSize(pageSize);
			//封装总的记录数
			int totalCount = inFurnitureDetailDao.findCount();
			pageBean.setTotalCount(totalCount);
			//封装总页数
			double tc = totalCount;
			Double num = Math.ceil(tc/pageSize);
			pageBean.setTotalPage(num.intValue());
			//封装每页显示的数据
			int begin = (currPage-1)*pageSize;
			List<InFurnitureDetail> list = inFurnitureDetailDao.findByPage(begin,pageSize);
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
		public void save(InFurnitureDetail inFurnitureDetail) {
			// TODO Auto-generated method stub
			inFurnitureDetailDao.save(inFurnitureDetail);
		}
		
		/**
		 * 业务层根据进货单ID查询进货单的方法
		 */
		@Override
		public InFurnitureDetail findById(Integer infid) {
			// TODO Auto-generated method stub
			return inFurnitureDetailDao.findById(infid);
		}
		
		/**
		 * 业务层更新进货单的方法
		 */
		@Override
		public void update(InFurnitureDetail inFurnitureDetail) {
			// TODO Auto-generated method stub
			inFurnitureDetailDao.update(inFurnitureDetail);
		}
		
		/**
		 * 业务层删除进货单的方法
		 */
		@Override
		public void delete(InFurnitureDetail inFurnitureDetail) {
			// TODO Auto-generated method stub
			inFurnitureDetailDao.delete(inFurnitureDetail);
		}
		

		/**
		 * 业务层根据进货单id查询进货详单的方法
		 */
		@Override
		public List<InFurnitureDetail> findAllByInfid(String in_fid) {
			// TODO Auto-generated method stub
			return inFurnitureDetailDao.findAllByInfid(in_fid);
		}
		
		/**
		 * 业务层根据仓库id查询进货详单的方法
		 */
		@Override
		public List<InFurnitureDetail> findAllBySid(String sid) {
			// TODO Auto-generated method stub
			return inFurnitureDetailDao.findAllBySid(sid);
		}
		
		/**
		 * 业务层根据仓库id和家具id查询进货详情单的方法
		 */
		@Override
		public InFurnitureDetail findBySidAndFid(String sid, String fid) {
			// TODO Auto-generated method stub
			return inFurnitureDetailDao.findBySidAndFid(sid,fid);
		}
		
		/**
		 * 业务层查询所有进货详单的方法
		 */
		@Override
		public List<InFurnitureDetail> findAll() {
			// TODO Auto-generated method stub
			return inFurnitureDetailDao.findAll();
		}
		
}
