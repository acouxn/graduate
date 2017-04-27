package com.aco.mana.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.aco.mana.dao.StorehouseDao;
import com.aco.mana.domain.Furniture;
import com.aco.mana.domain.PageBean;
import com.aco.mana.domain.Storehouse;
import com.aco.mana.service.StorehouseService;

/**
 * ҵ���ʵ�ֲֿ�Ĺ�����
 * @author Administrator
 *
 */
@Transactional
public class StorehouseServiceImpl implements StorehouseService{
	
	//ע��Dao�����
	StorehouseDao storehouseDao;
	
	public void setStorehouseDao(StorehouseDao storehouseDao) {
		this.storehouseDao = storehouseDao;
	}

	@Override
	public PageBean<Storehouse> findByPage(Integer currPage) {
		PageBean<Storehouse> pageBean =new PageBean<Storehouse>();
		//��װ��ǰ��ҳ��
		pageBean.setCurrPage(currPage);
		//��װÿҳ��ʾ�ļ�¼��
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//��װ�ܵļ�¼��
		int totalCount = storehouseDao.findCount();
		pageBean.setTotalCount(totalCount);
		//��װ��ҳ��
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		//��װÿҳ��ʾ������
		int begin = (currPage-1)*pageSize;
		List<Storehouse> list = storehouseDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}
	
	/**
	 * ҵ��㱣��ֿ�ķ���
	 */
	@Override
	public void save(Storehouse storehouse) {
		// TODO Auto-generated method stub
		storehouseDao.save(storehouse);
	}
	
	/**
	 * ҵ�����ݲֿ�ID��ѯ�ֿ�ķ���
	 */
	@Override
	public Storehouse findById(Integer sid) {
		// TODO Auto-generated method stub
		return storehouseDao.findById(sid);
	}
	
	/**
	 * ҵ�����²ֿ�ķ���
	 */
	@Override
	public void update(Storehouse storehouse) {
		// TODO Auto-generated method stub
		storehouseDao.update(storehouse);
	}
	
	/**
	 * ҵ���ɾ���ֿ�ķ���
	 */
	@Override
	public void delete(Storehouse storehouse) {
		// TODO Auto-generated method stub
		storehouseDao.delete(storehouse);
	}
	
	/**
	 * ҵ����ѯ���вֿ�ķ���
	 */
	@Override
	public List<Storehouse> findAll() {
		// TODO Auto-generated method stub
		return storehouseDao.finAll();
	}
}
