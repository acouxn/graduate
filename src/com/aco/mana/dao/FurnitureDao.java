package com.aco.mana.dao;

import java.util.List;

import com.aco.mana.domain.Furniture;
import com.aco.mana.domain.InFurniture;

public interface FurnitureDao {

	int findCount();

	List<Furniture> findByPage(int begin, int pageSize);

	void save(Furniture furniture);

	Furniture findById(Integer fid);

	void update(Furniture furniture);

	void delete(Furniture furniture);

	List<Furniture> finAll();

	List<Furniture> findAllByInid(InFurniture inFurniture);

}
