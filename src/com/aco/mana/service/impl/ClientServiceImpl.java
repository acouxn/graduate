package com.aco.mana.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.aco.mana.dao.ClientDao;
import com.aco.mana.domain.Client;
import com.aco.mana.domain.PageBean;
import com.aco.mana.service.ClientService;

/**
 * 客户信息管理业务层的实现类
 * 
 * @author Administrator
 * 
 */
@Transactional
public class ClientServiceImpl implements ClientService {

	// 注入Dao层的类
	ClientDao clientDao;

	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	/**
	 * 业务层分页查询客户的方法
	 */
	@Override
	public PageBean<Client> findByPage(Integer currPage) {
		PageBean<Client> pageBean = new PageBean<Client>();
		// 封装当前的页面
		pageBean.setCurrPage(currPage);
		// 封装每页显示的记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		// 封装总的记录数
		int totalCount = clientDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// 封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Client> list = clientDao.findByPage(begin, pageSize);
		pageBean.setList(list);

		return pageBean;
	}

	/**
	 * 业务层保存客户的方法
	 */
	@Override
	public void save(Client client) {
		// TODO Auto-generated method stub
		clientDao.save(client);
	}

	/**
	 * 业务层根据客户ID查询客户的方法
	 */
	@Override
	public Client findById(Integer cid) {
		// TODO Auto-generated method stub
		return clientDao.findById(cid);
	}

	/**
	 * 业务层更新客户的方法
	 */
	@Override
	public void update(Client client) {
		// TODO Auto-generated method stub
		clientDao.update(client);
	}

	/**
	 * 业务层删除客户的方法
	 */
	@Override
	public void delete(Client client) {
		// TODO Auto-generated method stub
		clientDao.delete(client);
	}
	
	/**
	 * 业务层查询客户的方法
	 */
	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return clientDao.findAll();
	}

}
