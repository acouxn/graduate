package com.aco.mana.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.aco.mana.dao.OutFurnitureDao;
import com.aco.mana.domain.OutFurniture;
import com.aco.mana.domain.PageBean;
import com.aco.mana.service.OutFurnitureService;

/**
 * ҵ���ʵ�����۵������ʵ����
 * @author Administrator
 *
 */
@Transactional
public class OutFurnitureServiceImpl implements OutFurnitureService{
	
	//ע��Dao�����
	OutFurnitureDao outFurnitureDao;

	public void setOutFurnitureDao(OutFurnitureDao outFurnitureDao) {
		this.outFurnitureDao = outFurnitureDao;
	}
	
	/**
	 *ҵ����ҳ��ѯ���۵��ķ���
	 */
	@Override
	public PageBean<OutFurniture> findByPage(Integer currPage) {
		PageBean<OutFurniture> pageBean =new PageBean<OutFurniture>();
		//��װ��ǰ��ҳ��
		pageBean.setCurrPage(currPage);
		//��װÿҳ��ʾ�ļ�¼��
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//��װ�ܵļ�¼��
		int totalCount = outFurnitureDao.findCount();
		pageBean.setTotalCount(totalCount);
		//��װ��ҳ��
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		//��װÿҳ��ʾ������
		int begin = (currPage-1)*pageSize;
		List<OutFurniture> list = outFurnitureDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}
	
	/**
	 * ҵ��㱣�����۵��ķ���
	 */
	@Override
	public void save(OutFurniture outFurniture) {
		// TODO Auto-generated method stub
		outFurnitureDao.save(outFurniture);
	}
	
	/**
	 * ҵ���������۵�ID��ѯ���۵��ķ���
	 */
	@Override
	public OutFurniture findById(Integer fid) {
		// TODO Auto-generated method stub
		return outFurnitureDao.findById(fid);
	}
	
	/**
	 * ҵ���������۵��ķ���
	 */
	@Override
	public void update(OutFurniture outFurniture) {
		// TODO Auto-generated method stub
		outFurnitureDao.update(outFurniture);
	}
	
	/**
	 * ҵ���ɾ�����۵��ķ���
	 */
	@Override
	public void delete(OutFurniture outFurniture) {
		// TODO Auto-generated method stub
		outFurnitureDao.delete(outFurniture);
	}
	
	/**
	 * ҵ����ѯ�������۵��ķ���
	 */
	@Override
	public List<OutFurniture> findAll() {
		// TODO Auto-generated method stub
		return outFurnitureDao.finAll();
	}
	
	
}
