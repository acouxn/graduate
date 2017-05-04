package com.aco.mana.dao;

import java.util.List;

import com.aco.mana.domain.OutFurniture;

public interface OutFurnitureDao {

	int findCount();

	List<OutFurniture> findByPage(int begin, int pageSize);

	void save(OutFurniture outFurniture);

	OutFurniture findById(Integer fid);

	void update(OutFurniture outFurniture);

	void delete(OutFurniture outFurniture);

	List<OutFurniture> finAll();


}
