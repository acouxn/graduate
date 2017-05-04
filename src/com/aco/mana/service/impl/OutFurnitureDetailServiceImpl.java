package com.aco.mana.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.aco.mana.dao.OutFurnitureDetailDao;
import com.aco.mana.domain.OutFurnitureDetail;
import com.aco.mana.domain.PageBean;
import com.aco.mana.service.OutFurnitureDetailService;

/**
 * 业务层销售详情单的实现类
 * @author Administrator
 *
 */
@Transactional
public class OutFurnitureDetailServiceImpl implements OutFurnitureDetailService{

	//注入Dao层的类
		OutFurnitureDetailDao outFurnitureDetailDao;

		public void setOutFurnitureDetailDao(OutFurnitureDetailDao outFurnitureDetailDao) {
			this.outFurnitureDetailDao = outFurnitureDetailDao;
		}

		@Override
		public PageBean<OutFurnitureDetail> findByPage(Integer currPage) {
			PageBean<OutFurnitureDetail> pageBean =new PageBean<OutFurnitureDetail>();
			//封装当前的页面
			pageBean.setCurrPage(currPage);
			//封装每页显示的记录数
			int pageSize = 3;
			pageBean.setPageSize(pageSize);
			//封装总的记录数
			int totalCount = outFurnitureDetailDao.findCount();
			pageBean.setTotalCount(totalCount);
			//封装总页数
			double tc = totalCount;
			Double num = Math.ceil(tc/pageSize);
			pageBean.setTotalPage(num.intValue());
			//封装每页显示的数据
			int begin = (currPage-1)*pageSize;
			List<OutFurnitureDetail> list = outFurnitureDetailDao.findByPage(begin,pageSize);
			//for(InFurniture inf:list){
			//		System.out.println("111111111111"+inf.getNum());
			//	}
			pageBean.setList(list);
			
			return pageBean;
		}
		
		/**
		 * 业务层保存销售详情单的方法
		 */
		@Override
		public void save(OutFurnitureDetail outFurnitureDetail) {
			// TODO Auto-generated method stub
			outFurnitureDetailDao.save(outFurnitureDetail);
		}
		
		/**
		 * 业务层更新销售详情单的方法
		 */
		@Override
		public void update(OutFurnitureDetail outFurnitureDetail) {
			// TODO Auto-generated method stub
			outFurnitureDetailDao.update(outFurnitureDetail);
		}
		
		/**
		 * 业务层删除销售详情单的方法
		 */
		@Override
		public void delete(OutFurnitureDetail outFurnitureDetail) {
			// TODO Auto-generated method stub
			outFurnitureDetailDao.delete(outFurnitureDetail);
		}
		

		/**
		 * 业务层根据销售详情单id查询销售详情详单的方法
		 */
		@Override
		public List<OutFurnitureDetail> findAllByOutfid(String out_fdid) {
			// TODO Auto-generated method stub
			return outFurnitureDetailDao.findAllByOutfid(out_fdid);
		}
		
		/**
		 * 业务层根据仓库id查询销售详情详单的方法
		 */
		@Override
		public List<OutFurnitureDetail> findAllBySid(String sid) {
			// TODO Auto-generated method stub
			return outFurnitureDetailDao.findAllBySid(sid);
		}
		
		/**
		 * 业务层根据销售详情单ID查询销售详情单的方法
		 */
		@Override
		public OutFurnitureDetail findByOid(String out_fid) {
			// TODO Auto-generated method stub
			return outFurnitureDetailDao.findByOid(out_fid);
		}
		
		/**
		 * 业务层根据销售详情单ID查询销售详情单的方法
		 */
		@Override
		public OutFurnitureDetail findById(Integer out_fid) {
			// TODO Auto-generated method stub
			return outFurnitureDetailDao.findById(out_fid);
		}
		
}
