package com.aco.mana.service;

import java.util.List;

import com.aco.mana.domain.OutFurniture;
import com.aco.mana.domain.PageBean;

public interface OutFurnitureService {

	PageBean<OutFurniture> findByPage(Integer currPage);

	void save(OutFurniture outFurniture);

	OutFurniture findById(Integer fid);

	void update(OutFurniture outFurniture);

	void delete(OutFurniture outFurniture);

	List<OutFurniture> findAll();


}
