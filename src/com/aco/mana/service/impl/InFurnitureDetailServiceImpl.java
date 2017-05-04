package com.aco.mana.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.aco.mana.dao.InFurnitureDetailDao;
import com.aco.mana.domain.InFurnitureDetail;
import com.aco.mana.domain.PageBean;
import com.aco.mana.service.InFurnitureDetailService;

/**
 * ҵ����������ʵ����
 * @author Administrator
 *
 */
@Transactional
public class InFurnitureDetailServiceImpl implements InFurnitureDetailService{

	//ע��Dao�����
		InFurnitureDetailDao inFurnitureDetailDao;

		public void setInFurnitureDetailDao(InFurnitureDetailDao inFurnitureDetailDao) {
			this.inFurnitureDetailDao = inFurnitureDetailDao;
		}

		@Override
		public PageBean<InFurnitureDetail> findByPage(Integer currPage) {
			PageBean<InFurnitureDetail> pageBean =new PageBean<InFurnitureDetail>();
			//��װ��ǰ��ҳ��
			pageBean.setCurrPage(currPage);
			//��װÿҳ��ʾ�ļ�¼��
			int pageSize = 3;
			pageBean.setPageSize(pageSize);
			//��װ�ܵļ�¼��
			int totalCount = inFurnitureDetailDao.findCount();
			pageBean.setTotalCount(totalCount);
			//��װ��ҳ��
			double tc = totalCount;
			Double num = Math.ceil(tc/pageSize);
			pageBean.setTotalPage(num.intValue());
			//��װÿҳ��ʾ������
			int begin = (currPage-1)*pageSize;
			List<InFurnitureDetail> list = inFurnitureDetailDao.findByPage(begin,pageSize);
			//for(InFurniture inf:list){
			//		System.out.println("111111111111"+inf.getNum());
			//	}
			pageBean.setList(list);
			
			return pageBean;
		}
		
		/**
		 * ҵ��㱣��������ķ���
		 */
		@Override
		public void save(InFurnitureDetail inFurnitureDetail) {
			// TODO Auto-generated method stub
			inFurnitureDetailDao.save(inFurnitureDetail);
		}
		
		/**
		 * ҵ�����ݽ�����ID��ѯ�������ķ���
		 */
		@Override
		public InFurnitureDetail findById(Integer infid) {
			// TODO Auto-generated method stub
			return inFurnitureDetailDao.findById(infid);
		}
		
		/**
		 * ҵ�����½������ķ���
		 */
		@Override
		public void update(InFurnitureDetail inFurnitureDetail) {
			// TODO Auto-generated method stub
			inFurnitureDetailDao.update(inFurnitureDetail);
		}
		
		/**
		 * ҵ���ɾ���������ķ���
		 */
		@Override
		public void delete(InFurnitureDetail inFurnitureDetail) {
			// TODO Auto-generated method stub
			inFurnitureDetailDao.delete(inFurnitureDetail);
		}
		

		/**
		 * ҵ�����ݽ�����id��ѯ�����굥�ķ���
		 */
		@Override
		public List<InFurnitureDetail> findAllByInfid(String in_fid) {
			// TODO Auto-generated method stub
			return inFurnitureDetailDao.findAllByInfid(in_fid);
		}
		
		/**
		 * ҵ�����ݲֿ�id��ѯ�����굥�ķ���
		 */
		@Override
		public List<InFurnitureDetail> findAllBySid(String sid) {
			// TODO Auto-generated method stub
			return inFurnitureDetailDao.findAllBySid(sid);
		}
		
		/**
		 * ҵ�����ݲֿ�id�ͼҾ�id��ѯ�������鵥�ķ���
		 */
		@Override
		public InFurnitureDetail findBySidAndFid(String sid, String fid) {
			// TODO Auto-generated method stub
			return inFurnitureDetailDao.findBySidAndFid(sid,fid);
		}
		
		/**
		 * ҵ����ѯ���н����굥�ķ���
		 */
		@Override
		public List<InFurnitureDetail> findAll() {
			// TODO Auto-generated method stub
			return inFurnitureDetailDao.findAll();
		}
		
}
