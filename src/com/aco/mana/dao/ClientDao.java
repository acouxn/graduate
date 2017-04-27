package com.aco.mana.dao;

import java.util.List;

import com.aco.mana.domain.Client;

public interface ClientDao {

	int findCount();

	List<Client> findByPage(int begin, int pageSize);

	void save(Client client);

	Client findById(Integer cid);

	void update(Client client);

	void delete(Client client);

}
