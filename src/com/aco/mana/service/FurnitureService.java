package com.aco.mana.service;

import java.util.List;

import com.aco.mana.domain.Furniture;
import com.aco.mana.domain.InFurniture;
import com.aco.mana.domain.PageBean;

public interface FurnitureService {

	PageBean<Furniture> findByPage(Integer currPage);

	void save(Furniture furniture);

	Furniture findById(Integer fid);

	void update(Furniture furniture);

	void delete(Furniture furniture);

	List<Furniture> findAll();

	List<Furniture> findAllByInid(InFurniture inFurniture);

}
