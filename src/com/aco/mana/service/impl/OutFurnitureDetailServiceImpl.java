package com.aco.mana.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.aco.mana.dao.OutFurnitureDetailDao;
import com.aco.mana.domain.OutFurnitureDetail;
import com.aco.mana.domain.PageBean;
import com.aco.mana.service.OutFurnitureDetailService;

/**
 * ҵ����������鵥��ʵ����
 * @author Administrator
 *
 */
@Transactional
public class OutFurnitureDetailServiceImpl implements OutFurnitureDetailService{

	//ע��Dao�����
		OutFurnitureDetailDao outFurnitureDetailDao;

		public void setOutFurnitureDetailDao(OutFurnitureDetailDao outFurnitureDetailDao) {
			this.outFurnitureDetailDao = outFurnitureDetailDao;
		}

		@Override
		public PageBean<OutFurnitureDetail> findByPage(Integer currPage) {
			PageBean<OutFurnitureDetail> pageBean =new PageBean<OutFurnitureDetail>();
			//��װ��ǰ��ҳ��
			pageBean.setCurrPage(currPage);
			//��װÿҳ��ʾ�ļ�¼��
			int pageSize = 3;
			pageBean.setPageSize(pageSize);
			//��װ�ܵļ�¼��
			int totalCount = outFurnitureDetailDao.findCount();
			pageBean.setTotalCount(totalCount);
			//��װ��ҳ��
			double tc = totalCount;
			Double num = Math.ceil(tc/pageSize);
			pageBean.setTotalPage(num.intValue());
			//��װÿҳ��ʾ������
			int begin = (currPage-1)*pageSize;
			List<OutFurnitureDetail> list = outFurnitureDetailDao.findByPage(begin,pageSize);
			//for(InFurniture inf:list){
			//		System.out.println("111111111111"+inf.getNum());
			//	}
			pageBean.setList(list);
			
			return pageBean;
		}
		
		/**
		 * ҵ��㱣���������鵥�ķ���
		 */
		@Override
		public void save(OutFurnitureDetail outFurnitureDetail) {
			// TODO Auto-generated method stub
			outFurnitureDetailDao.save(outFurnitureDetail);
		}
		
		/**
		 * ҵ�������������鵥�ķ���
		 */
		@Override
		public void update(OutFurnitureDetail outFurnitureDetail) {
			// TODO Auto-generated method stub
			outFurnitureDetailDao.update(outFurnitureDetail);
		}
		
		/**
		 * ҵ���ɾ���������鵥�ķ���
		 */
		@Override
		public void delete(OutFurnitureDetail outFurnitureDetail) {
			// TODO Auto-generated method stub
			outFurnitureDetailDao.delete(outFurnitureDetail);
		}
		

		/**
		 * ҵ�������������鵥id��ѯ���������굥�ķ���
		 */
		@Override
		public List<OutFurnitureDetail> findAllByOutfid(String out_fdid) {
			// TODO Auto-generated method stub
			return outFurnitureDetailDao.findAllByOutfid(out_fdid);
		}
		
		/**
		 * ҵ�����ݲֿ�id��ѯ���������굥�ķ���
		 */
		@Override
		public List<OutFurnitureDetail> findAllBySid(String sid) {
			// TODO Auto-generated method stub
			return outFurnitureDetailDao.findAllBySid(sid);
		}
		
		/**
		 * ҵ�������������鵥ID��ѯ�������鵥�ķ���
		 */
		@Override
		public OutFurnitureDetail findByOid(String out_fid) {
			// TODO Auto-generated method stub
			return outFurnitureDetailDao.findByOid(out_fid);
		}
		
		/**
		 * ҵ�������������鵥ID��ѯ�������鵥�ķ���
		 */
		@Override
		public OutFurnitureDetail findById(Integer out_fid) {
			// TODO Auto-generated method stub
			return outFurnitureDetailDao.findById(out_fid);
		}
		
}
