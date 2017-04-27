package com.aco.mana.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.aco.mana.dao.FurnitureDao;
import com.aco.mana.domain.Furniture;
import com.aco.mana.domain.InFurniture;
import com.aco.mana.domain.PageBean;
import com.aco.mana.service.FurnitureService;

/**
 * ҵ���ʵ�ֻ�������ʵ����
 * @author Administrator
 *
 */
@Transactional
public class FurnitureServiceImpl implements FurnitureService{
	
	//ע��Dao�����
	FurnitureDao furnitureDao;

	public void setFurnitureDao(FurnitureDao furnitureDao) {
		this.furnitureDao = furnitureDao;
	}
	
	/**
	 *ҵ����ҳ��ѯ����ķ���
	 */
	@Override
	public PageBean<Furniture> findByPage(Integer currPage) {
		PageBean<Furniture> pageBean =new PageBean<Furniture>();
		//��װ��ǰ��ҳ��
		pageBean.setCurrPage(currPage);
		//��װÿҳ��ʾ�ļ�¼��
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//��װ�ܵļ�¼��
		int totalCount = furnitureDao.findCount();
		pageBean.setTotalCount(totalCount);
		//��װ��ҳ��
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		//��װÿҳ��ʾ������
		int begin = (currPage-1)*pageSize;
		List<Furniture> list = furnitureDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}
	
	/**
	 * ҵ��㱣�����ķ���
	 */
	@Override
	public void save(Furniture furniture) {
		// TODO Auto-generated method stub
		furnitureDao.save(furniture);
	}
	
	/**
	 * ҵ�����ݻ���ID��ѯ����ķ���
	 */
	@Override
	public Furniture findById(Integer fid) {
		// TODO Auto-generated method stub
		return furnitureDao.findById(fid);
	}
	
	/**
	 * ҵ�����»���ķ���
	 */
	@Override
	public void update(Furniture furniture) {
		// TODO Auto-generated method stub
		furnitureDao.update(furniture);
	}
	
	/**
	 * ҵ���ɾ������ķ���
	 */
	@Override
	public void delete(Furniture furniture) {
		// TODO Auto-generated method stub
		furnitureDao.delete(furniture);
	}
	
	/**
	 * ҵ����ѯ���л���ķ���
	 */
	@Override
	public List<Furniture> findAll() {
		// TODO Auto-generated method stub
		return furnitureDao.finAll();
	}
	
	/**
	 * ҵ�����ݶ���id��ѯ����ķ���
	 */
	@Override
	public List<Furniture> findAllByInid(InFurniture inFurniture) {
		// TODO Auto-generated method stub
		List<Furniture> flist = furnitureDao.findAllByInid(inFurniture);

		return flist;
	}

}
