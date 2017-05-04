package com.aco.mana.service;

import java.util.List;

import com.aco.mana.domain.InFurniture;
import com.aco.mana.domain.PageBean;

public interface InFurnitureService {

	PageBean<InFurniture> findByPage(Integer currPage);

	void save(InFurniture inFurniture);

	InFurniture findById(Integer fid);

	void update(InFurniture inFurniture);

	void delete(InFurniture inFurniture);

	List<InFurniture> findAll();


}
