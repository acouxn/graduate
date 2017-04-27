package com.aco.mana.dao;

import java.util.List;

import com.aco.mana.domain.Storehouse;

public interface StorehouseDao {

	int findCount();

	List<Storehouse> findByPage(int begin, int pageSize);

	void save(Storehouse storehouse);

	Storehouse findById(Integer sid);

	void update(Storehouse storehouse);

	void delete(Storehouse storehouse);

	List<Storehouse> finAll();


}
