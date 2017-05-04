package com.aco.mana.dao;

import java.util.List;

import com.aco.mana.domain.OutFurnitureDetail;


public interface OutFurnitureDetailDao {

	int findCount();

	List<OutFurnitureDetail> findByPage(int begin, int pageSize);

	void save(OutFurnitureDetail outFurnitureDetail);
	
	OutFurnitureDetail findById(Integer infid);

	void update(OutFurnitureDetail outFurnitureDetail);

	void delete(OutFurnitureDetail outFurnitureDetail);

	List<OutFurnitureDetail> findAllByOutfid(String out_fdid);

	List<OutFurnitureDetail> findAllBySid(String sid);

	OutFurnitureDetail findByOid(String out_fid);

}
