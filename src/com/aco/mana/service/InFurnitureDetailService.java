package com.aco.mana.service;

import java.util.List;

import com.aco.mana.domain.InFurnitureDetail;
import com.aco.mana.domain.PageBean;

public interface InFurnitureDetailService {

	PageBean<InFurnitureDetail> findByPage(Integer currPage);

	InFurnitureDetail findById(Integer in_fid);

	void update(InFurnitureDetail inFurnitureDetail);

	void delete(InFurnitureDetail inFurnitureDetail);

	void save(InFurnitureDetail inFurnitureDetail);

	List<InFurnitureDetail> findAllByInfid(String in_fid);

	List<InFurnitureDetail> findAllBySid(String sid);

	InFurnitureDetail findBySidAndFid(String sid, String fid);

	List<InFurnitureDetail> findAll();

}
