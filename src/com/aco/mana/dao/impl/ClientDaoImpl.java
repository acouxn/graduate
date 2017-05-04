package com.aco.mana.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aco.mana.dao.ClientDao;
import com.aco.mana.domain.Client;

/**
 * �ͻ���Ϣ�����Dao��ʵ����
 * 
 * @author Administrator
 * 
 */
public class ClientDaoImpl extends HibernateDaoSupport implements ClientDao {

	/**
	 * dao���ѯ�ͻ���Ϣ�ܼ�¼���ķ���
	 */
	@Override
	public int findCount() {
		String hql = "select count(*) from Client";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	/**
	 * dao���ҳ��ѯ�ͻ���Ϣ
	 */
	@Override
	public List<Client> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Client.class);
		List<Client> list = this.getHibernateTemplate().findByCriteria(
				criteria, begin, pageSize);
		return list;
	}

	/**
	 * dao�㱣��ͻ���Ϣ
	 */
	@Override
	public void save(Client client) {
		this.getHibernateTemplate().save(client);
	}

	/**
	 * dao����ݿͻ���ϢID��ѯ�ͻ���Ϣ�ķ���
	 */
	@Override
	public Client findById(Integer cid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Client.class, cid);
	}

	/**
	 * Dao���޸Ŀͻ���Ϣ�ķ���
	 */
	@Override
	public void update(Client client) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(client);
	}

	/**
	 * Dao��ɾ���ͻ���Ϣ�ķ���
	 */
	@Override
	public void delete(Client client) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(client);
	}
	
	/**
	 * Dao���ѯ���пͻ���Ϣ�ķ���
	 */
	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Client");
	}

}
