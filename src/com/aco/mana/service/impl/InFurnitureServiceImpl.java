package com.aco.mana.service.impl;

import java.util.List;

import com.aco.mana.dao.InFurnitureDao;
import com.aco.mana.domain.InFurniture;
import com.aco.mana.domain.PageBean;
import com.aco.mana.service.InFurnitureService;

/**
 * ҵ����������ʵ����
 * @author Administrator
 *
 */
public class InFurnitureServiceImpl implements InFurnitureService{

	//ע��Dao�����
		InFurnitureDao inFurnitureDao;
		
		public void setInFurnitureDao(InFurnitureDao inFurnitureDao) {
			this.inFurnitureDao = inFurnitureDao;
		}

		@Override
		public PageBean<InFurniture> findByPage(Integer currPage) {
			PageBean<InFurniture> pageBean =new PageBean<InFurniture>();
			//��װ��ǰ��ҳ��
			pageBean.setCurrPage(currPage);
			//��װÿҳ��ʾ�ļ�¼��
			int pageSize = 3;
			pageBean.setPageSize(pageSize);
			//��װ�ܵļ�¼��
			int totalCount = inFurnitureDao.findCount();
			pageBean.setTotalCount(totalCount);
			//��װ��ҳ��
			double tc = totalCount;
			Double num = Math.ceil(tc/pageSize);
			pageBean.setTotalPage(num.intValue());
			//��װÿҳ��ʾ������
			int begin = (currPage-1)*pageSize;
			List<InFurniture> list = inFurnitureDao.findByPage(begin,pageSize);
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
		public void save(InFurniture inFurniture) {
			// TODO Auto-generated method stub
			inFurnitureDao.save(inFurniture);
		}
		
		/**
		 * ҵ�����ݽ�����ID��ѯ�������ķ���
		 */
		@Override
		public InFurniture findById(Integer iid) {
			// TODO Auto-generated method stub
			return inFurnitureDao.findById(iid);
		}
		
		/**
		 * ҵ�����½������ķ���
		 */
		@Override
		public void update(InFurniture inFurniture) {
			// TODO Auto-generated method stub
			inFurnitureDao.update(inFurniture);
		}
		
		/**
		 * ҵ���ɾ���������ķ���
		 */
		@Override
		public void delete(InFurniture inFurniture) {
			// TODO Auto-generated method stub
			inFurnitureDao.delete(inFurniture);
		}
		
}
