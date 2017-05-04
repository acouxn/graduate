package com.aco.mana.service;

import java.util.List;

import com.aco.mana.domain.PageBean;
import com.aco.mana.domain.Storehouse;

public interface StorehouseService {

	PageBean<Storehouse> findByPage(Integer currPage);

	void save(Storehouse storehouse);

	Storehouse findById(Integer sid);

	void update(Storehouse storehouse);

	void delete(Storehouse storehouse);

	List<Storehouse> findAll();


}
