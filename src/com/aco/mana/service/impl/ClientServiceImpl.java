package com.aco.mana.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.aco.mana.dao.ClientDao;
import com.aco.mana.domain.Client;
import com.aco.mana.domain.PageBean;
import com.aco.mana.service.ClientService;

/**
 * �ͻ���Ϣ����ҵ����ʵ����
 * 
 * @author Administrator
 * 
 */
@Transactional
public class ClientServiceImpl implements ClientService {

	// ע��Dao�����
	ClientDao clientDao;

	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	/**
	 * ҵ����ҳ��ѯ����ķ���
	 */
	@Override
	public PageBean<Client> findByPage(Integer currPage) {
		PageBean<Client> pageBean = new PageBean<Client>();
		// ��װ��ǰ��ҳ��
		pageBean.setCurrPage(currPage);
		// ��װÿҳ��ʾ�ļ�¼��
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		// ��װ�ܵļ�¼��
		int totalCount = clientDao.findCount();
		pageBean.setTotalCount(totalCount);
		// ��װ��ҳ��
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// ��װÿҳ��ʾ������
		int begin = (currPage - 1) * pageSize;
		List<Client> list = clientDao.findByPage(begin, pageSize);
		pageBean.setList(list);

		return pageBean;
	}

	/**
	 * ҵ��㱣�����ķ���
	 */
	@Override
	public void save(Client client) {
		// TODO Auto-generated method stub
		clientDao.save(client);
	}

	/**
	 * ҵ�����ݻ���ID��ѯ����ķ���
	 */
	@Override
	public Client findById(Integer cid) {
		// TODO Auto-generated method stub
		return clientDao.findById(cid);
	}

	/**
	 * ҵ�����»���ķ���
	 */
	@Override
	public void update(Client client) {
		// TODO Auto-generated method stub
		clientDao.update(client);
	}

	/**
	 * ҵ���ɾ������ķ���
	 */
	@Override
	public void delete(Client client) {
		// TODO Auto-generated method stub
		clientDao.delete(client);
	}

}
