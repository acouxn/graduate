package com.aco.mana.service;

import java.util.List;

import com.aco.mana.domain.OutFurnitureDetail;
import com.aco.mana.domain.PageBean;

public interface OutFurnitureDetailService {

	PageBean<OutFurnitureDetail> findByPage(Integer currPage);

	OutFurnitureDetail findById(Integer out_fid);

	void update(OutFurnitureDetail outFurnitureDetail);

	void delete(OutFurnitureDetail outFurnitureDetail);

	void save(OutFurnitureDetail outFurnitureDetail);

	List<OutFurnitureDetail> findAllByOutfid(String in_fdid);

	List<OutFurnitureDetail> findAllBySid(String sid);

	OutFurnitureDetail findByOid(String out_fid);

}
