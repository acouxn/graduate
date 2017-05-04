package com.aco.mana.service;

import java.util.List;

import com.aco.mana.domain.Client;
import com.aco.mana.domain.PageBean;

public interface ClientService {

	void save(Client client);

	Client findById(Integer cid);

	void update(Client client);

	void delete(Client client);

	PageBean<Client> findByPage(Integer currPage);

	List<Client> findAll();

}
