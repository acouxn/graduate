package com.aco.mana.dao;

import java.util.List;

import com.aco.mana.domain.InFurnitureDetail;


public interface InFurnitureDetailDao {

	int findCount();

	List<InFurnitureDetail> findByPage(int begin, int pageSize);

	void save(InFurnitureDetail inFurnitureDetail);
	
	InFurnitureDetail findById(Integer infid);

	void update(InFurnitureDetail inFurnitureDetail);

	void delete(InFurnitureDetail inFurnitureDetail);

	List<InFurnitureDetail> findAllByInfid(String in_fid);

	List<InFurnitureDetail> findAllBySid(String sid);

	InFurnitureDetail findBySidAndFid(String sid, String fid);

	List<InFurnitureDetail> findAll();

}
