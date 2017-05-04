package com.aco.mana.dao;

import java.util.List;

import com.aco.mana.domain.InFurniture;

public interface InFurnitureDao {

	int findCount();

	List<InFurniture> findByPage(int begin, int pageSize);

	void save(InFurniture inFurniture);

	InFurniture findById(Integer fid);

	void update(InFurniture inFurniture);

	void delete(InFurniture inFurniture);

	List<InFurniture> finAll();


}
